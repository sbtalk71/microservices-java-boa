package com.demo.java17.sealedinterfaces;

public non-sealed class CreditCardPayment implements Payment{

	@Override
	public void pay(double amount) {
		System.out.println("paid by credit card");
		
	}

}
