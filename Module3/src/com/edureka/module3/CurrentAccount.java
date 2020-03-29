package com.edureka.module3;

public final class CurrentAccount extends Account {

	final double minBalance = 2000.00;
	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		System.out.println("in current bank account deposit");
	}

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		System.out.println("in current bank account withdraw");
	}
}
