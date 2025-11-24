package com.demo.java17.sealedclass;

public final class NetBankingPayment extends Payment{

	@Override
	public void pay(double amount) {
		System.out.println("Paid through Net Banking..");
		
	}

}
