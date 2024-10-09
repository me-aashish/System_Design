package org.example.Strategy;

public class CardStrategy implements PayStrategy, AuthStrategy {

	@Override
	public void auth() {
		System.out.println("Card Auth");
	}

	@Override
	public void payBill() {
		System.out.println("Card Payment");
	}
}
