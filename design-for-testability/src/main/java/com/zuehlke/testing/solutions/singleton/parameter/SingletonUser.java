package com.zuehlke.testing.solutions.singleton.parameter;

public class SingletonUser {

	private EagerSingleton eager;
	private LazySingleton lazy;

	public SingletonUser(EagerSingleton eager, LazySingleton lazy) {
		super();
		this.eager = eager;
		this.lazy = lazy;
	}

	public void doSomething() {
		eager.increaseCounter();
		lazy.increaseCounter();
	}
}
