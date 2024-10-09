package org.example;

public class StarbucksCardPayment extends Payment {

	@Override
	public void pay() {
		System.out.println("starbucks pay");
	}

	@Override
	public void auth() {
		try {
			throw new Exception("no auth required for this payment");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
