package com.edureka.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.edureka.DAO.TransactionDAO;
import com.edureka.Model.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	private static final String DEBIT_SUCCESS_MSG = "Amount debited from the specified account number successfully.";
	private static final String DEBIT_ERROR_MSG = "The debit operation failed.";
	
	private static final String CREDIT_SUCCESS_MSG = "Amount credited to the specified account number successfully.";
	private static final String CREDIT_ERROR_MSG = "The credit operation failed.";

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public String debitFromAccount(int account_Number, int amount) {
		@SuppressWarnings("unchecked")
		List<Transaction> userList = (List<Transaction>)hibernateTemplate.find("from Transaction where account_number = ?", account_Number);
		Transaction user = userList.get(0);
		user.setBalance(user.getBalance() - amount);
		
		@SuppressWarnings("unchecked")
		List<Transaction> loggedInUserList = (List<Transaction>)hibernateTemplate.find("from Transaction where name = ?", "Arpit");
		Transaction loggedInUser = loggedInUserList.get(0);
		loggedInUser.setBalance(loggedInUser.getBalance() + amount);
		
		try {
			
			Session session = hibernateTemplate.getSessionFactory().openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			session.update(user);
			session.update(loggedInUser);
			tx.commit();
			session.close();
			return DEBIT_SUCCESS_MSG;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return DEBIT_ERROR_MSG;
		}
	}

	@Override
	public String creditToAccount(int account_Number, int amount) {
		@SuppressWarnings("unchecked")
		List<Transaction> userList = (List<Transaction>)hibernateTemplate.find("from Transaction where account_number = ?", account_Number);
		Transaction user = userList.get(0);
		user.setBalance(user.getBalance() + amount);
		
		@SuppressWarnings("unchecked")
		List<Transaction> loggedInUserList = (List<Transaction>)hibernateTemplate.find("from Transaction where name = ?", "Arpit");
		Transaction loggedInUser = loggedInUserList.get(0);
		loggedInUser.setBalance(loggedInUser.getBalance() - amount);
		
		try {
			
			Session session = hibernateTemplate.getSessionFactory().openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			session.update(user);
			session.update(loggedInUser);
			tx.commit();
			session.close();
			return CREDIT_SUCCESS_MSG;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return CREDIT_ERROR_MSG;
		}
	}

}
