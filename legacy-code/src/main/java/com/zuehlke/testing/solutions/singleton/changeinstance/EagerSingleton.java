package com.zuehlke.testing.solutions.singleton.changeinstance;

public class EagerSingleton {

	private static EagerSingleton INSTANCE = new EagerSingleton();

	public static EagerSingleton getInstance() {
		return INSTANCE;
	}

	static void setInstance(EagerSingleton eager) {
		INSTANCE = eager;
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
