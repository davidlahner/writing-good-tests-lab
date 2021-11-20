package com.zuehlke.testing.solutions.singleton.parameter;

public class EagerSingleton {

	private static final EagerSingleton INSTANCE = new EagerSingleton();

	public static EagerSingleton getInstance() {
		return INSTANCE;
	}

	EagerSingleton() {
		System.out.println("EagerSingleton created");
	}

	private int counter;

	public void increaseCounter() {
		counter++;
	}

	public int getCounter() {
		return counter;
	}

}
