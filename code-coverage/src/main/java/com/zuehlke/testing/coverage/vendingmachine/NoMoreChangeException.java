package com.zuehlke.testing.coverage.vendingmachine;

/**
 * Exception if the machine ran out of change
 * 
 * @author brt
 */
public class NoMoreChangeException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoMoreChangeException(String message) {
		super(message);
	}

}
