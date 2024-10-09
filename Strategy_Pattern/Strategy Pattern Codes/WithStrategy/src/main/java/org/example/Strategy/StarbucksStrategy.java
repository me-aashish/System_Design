package org.example.Strategy;

public class StarbucksStrategy implements PayStrategy {
	@Override
	public void payBill() {
		System.out.println("starbucks card payment");
	}
}
