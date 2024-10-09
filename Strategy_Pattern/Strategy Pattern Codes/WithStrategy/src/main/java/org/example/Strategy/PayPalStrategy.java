package org.example.Strategy;

public class PayPalStrategy implements AuthStrategy, PayStrategy {
	@Override
	public void auth() {
		System.out.println("paypal auth");
	}

	@Override
	public void payBill() {
		System.out.println("paypal payment");
	}
}
