package org.example;

import org.example.Strategy.AuthStrategy;
import org.example.Strategy.CardStrategy;
import org.example.Strategy.PayStrategy;

public class RupayCreditCardPayment extends Payment {
	PayStrategy payStrategy;
	AuthStrategy authStrategy;
	public RupayCreditCardPayment() {
		super(new CardStrategy(), new CardStrategy());
	}


}
