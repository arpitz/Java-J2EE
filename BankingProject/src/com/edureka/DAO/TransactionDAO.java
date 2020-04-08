package com.edureka.DAO;

public interface TransactionDAO {
	
	public abstract String debitFromAccount(int account_Number, int amount);
	
	public abstract String creditToAccount(int account_Number, int amount);

}
