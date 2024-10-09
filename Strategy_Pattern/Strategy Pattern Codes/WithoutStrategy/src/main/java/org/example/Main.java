package org.example;

public class Main {
	public static void main(String[] args) {
		// this will work
//		Payment paymentObj = new CardPayment();
//		paymentObj.pay();

		// this will throw exception
		Payment paymentObj = new StarbucksCardPayment();

		paymentObj.auth();


	}
}