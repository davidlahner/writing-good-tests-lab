package com.zuehlke.testing.coverage.vendingmachine;

/**
 * Exception if the customer did not enter enough money
 * 
 * @author brt
 */
public class NotEnoughMoneyException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotEnoughMoneyException(String message) {
		super(message);
	}

}
