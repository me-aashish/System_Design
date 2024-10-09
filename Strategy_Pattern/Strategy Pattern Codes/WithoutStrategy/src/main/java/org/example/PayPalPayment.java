package org.example;

public class PayPalPayment extends Payment {

	@Override
	public void auth() {
		System.out.println("paypal auth");
	}

	@Override
	public void pay() {
		System.out.println("paypal auth");
	}
}
