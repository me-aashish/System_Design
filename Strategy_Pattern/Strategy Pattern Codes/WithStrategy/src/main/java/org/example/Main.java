package org.example;

public class Main {
	public static void main(String[] args) {
		Payment paymentObj = new RupayCreditCardPayment();

		paymentObj.auth();
		paymentObj.pay();

		Payment paymentObj2 = new StarbucksGiftCardPayment();

		paymentObj2.pay();


	}
}