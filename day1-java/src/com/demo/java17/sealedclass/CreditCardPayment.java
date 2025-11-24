package com.demo.java17.sealedclass;

public non-sealed class CreditCardPayment extends Payment{

	@Override
	public void pay(double amount) {
		System.out.println("paid by credit card");
		
	}

}
