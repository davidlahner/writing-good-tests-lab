package com.zuehlke.testing.examples.singleton;

public class EagerSingleton {

	private static final EagerSingleton INSTANCE = new EagerSingleton();

	public static EagerSingleton getInstance() {
		return INSTANCE;
	}

	private EagerSingleton() {
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
