package com.zuehlke.testing.examples.singleton;

public class SingletonUser {

	private static final EagerSingleton EAGER = EagerSingleton.getInstance();
	private static final LazySingleton LAZY = LazySingleton.getInstance();

	public void doSomething() {
		EAGER.increaseCounter();
		LAZY.increaseCounter();
	}
}
