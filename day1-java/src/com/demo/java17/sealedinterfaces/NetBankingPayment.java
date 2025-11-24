package com.demo.java17.sealedinterfaces;

public final class NetBankingPayment implements Payment{

	@Override
	public void pay(double amount) {
		System.out.println("Paid through Net Banking..");
		
	}

}
