package org.example;

import org.example.Strategy.PayStrategy;
import org.example.Strategy.StarbucksStrategy;

public class StarbucksGiftCardPayment extends Payment {
	public StarbucksGiftCardPayment() {
		super(new StarbucksStrategy());
	}
}
