package org.example;

import org.example.Strategy.AuthStrategy;
import org.example.Strategy.PayStrategy;

public class Payment {
	PayStrategy payStrategy;
	AuthStrategy authStrategy;
	public Payment(PayStrategy payStrategy, AuthStrategy authStrategy) {
		this.payStrategy = payStrategy;
		this.authStrategy = authStrategy;
	}

	public Payment(PayStrategy payStrategy) {
		this.payStrategy = payStrategy;
	}

	public void pay(){
		payStrategy.payBill();
	}

	public void auth(){
		authStrategy.auth();
	}
}
