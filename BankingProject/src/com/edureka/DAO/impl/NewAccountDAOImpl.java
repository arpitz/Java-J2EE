package com.edureka.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.edureka.DAO.NewAccountDAO;
import com.edureka.Model.NewAccount;

@Repository
public class NewAccountDAOImpl implements NewAccountDAO {
	
	private static final String ACCOUNT_SUCCESS_MSG = "Account created successfully.";
	private static final String ACCOUNT_ERROR_MSG = "User Account is not created";
	
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public String createNewAccount(NewAccount newAccount) {
		hibernateTemplate.setCheckWriteOperations(false);
		try {
			hibernateTemplate.save(newAccount);
			return ACCOUNT_SUCCESS_MSG;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ACCOUNT_ERROR_MSG;
		}	
	}

}
