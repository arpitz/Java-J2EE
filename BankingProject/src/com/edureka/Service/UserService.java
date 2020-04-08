package com.edureka.Service;

import java.util.List;

import com.edureka.Model.CreditCard;
import com.edureka.Model.NewAccount;
import com.edureka.Model.Record;
import com.edureka.Model.User;

public interface UserService {
	
	public abstract User fetchUserById(int userId);
	
	public abstract String createAccount(NewAccount newAccount);
	
	public abstract CreditCard authorizeCreditCard(CreditCard creditCard);
	
	public abstract String debitFromAccount(int account_Number, int amount);
	
	public abstract String creditToAccount(int account_Number, int amount);
	
	public abstract List<Record> fetchAllRecords(String fromDate, String toDate);

}
