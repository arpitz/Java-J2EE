package com.edureka.module3;

public final class SBAccount extends Account {

	float interest = 4.0f;
	final double minBalance = 10000.00;

	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		System.out.println("in savings bank account deposit");
	}

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		System.out.println("in savings bank account withdraw");
	}
	
	
}
