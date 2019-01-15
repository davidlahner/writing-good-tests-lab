package com.zuehlke.testing.solutions.singleton.changeinstance;

public class SingletonUser {

	private final EagerSingleton eager = EagerSingleton.getInstance();
	private final LazySingleton lazy = LazySingleton.getInstance();

	public void doSomething() {
		eager.increaseCounter();
		lazy.increaseCounter();
	}
}
