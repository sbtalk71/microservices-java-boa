package com.demo.java17.sealedinterfaces;

public  sealed interface Payment permits CreditCardPayment,NetBankingPayment{

	public abstract void pay(double amount);
}
