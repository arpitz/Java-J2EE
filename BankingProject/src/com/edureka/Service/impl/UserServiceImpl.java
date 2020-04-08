package com.edureka.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edureka.DAO.CreditCardDAO;
import com.edureka.DAO.NewAccountDAO;
import com.edureka.DAO.RecordDAO;
import com.edureka.DAO.TransactionDAO;
import com.edureka.DAO.UserDAO;
import com.edureka.Model.CreditCard;
import com.edureka.Model.NewAccount;
import com.edureka.Model.Record;
import com.edureka.Model.User;
import com.edureka.Service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;
	private NewAccountDAO newAccountDAO;
	private CreditCardDAO creditCardDAO;
	private TransactionDAO transactionDAO;
	private RecordDAO recordDAO;
	
	@Autowired
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	@Autowired
	public void setNewAccountDAO(NewAccountDAO newAccountDAO){
		this.newAccountDAO = newAccountDAO;
	}
	
	@Autowired
	public void setCreditCardDAO(CreditCardDAO ccardDAO){
		this.creditCardDAO = ccardDAO;
	}
	
	@Autowired
	public void setTransactionDAO(TransactionDAO transactionDAO){
		this.transactionDAO = transactionDAO;
	}
	
	@Autowired
	public void setRecordDAO(RecordDAO recordDAO){
		this.recordDAO = recordDAO;
	}

	@Override
	public User fetchUserById(int userId) {
		return userDAO.getUserById(userId);
	}

	@Override
	public String createAccount(NewAccount newAccount) {
		String result = newAccountDAO.createNewAccount(newAccount);
		return result;
		
	}

	@Override
	public CreditCard authorizeCreditCard(CreditCard creditCard) {
		CreditCard cCard = creditCardDAO.authorizeCardDetails(creditCard);
		return cCard;
	}

	@Override
	public String debitFromAccount(int account_Number, int amount) {
		return transactionDAO.debitFromAccount(account_Number, amount);
	}

	@Override
	public String creditToAccount(int account_Number, int amount) {
		return transactionDAO.creditToAccount(account_Number, amount);
	}

	@Override
	public List<Record> fetchAllRecords(String fromDate, String toDate) {
		return recordDAO.fetchAllRecords(fromDate, toDate);
	}

}
