package com.edureka.module3;
import java.util.*;

public abstract class Account {
	
	int accountNumber;
	String name;
	double amount;
	
	public abstract void deposit();
	public abstract void withdraw();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the account to be created");
		String account = sc.next();
		if(account.equalsIgnoreCase("sbaccount")){
			Account a = new SBAccount();
			a.deposit();
			a.withdraw();
		} else {
			Account a = new CurrentAccount();
			a.deposit();
			a.withdraw();
		}

	}

}
