package com.demo.java17.sealedclass;

public  sealed abstract class Payment permits CreditCardPayment,NetBankingPayment{

	public abstract void pay(double amount);
}
