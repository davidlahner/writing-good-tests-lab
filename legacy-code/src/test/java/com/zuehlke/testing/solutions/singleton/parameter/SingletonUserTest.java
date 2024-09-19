package com.zuehlke.testing.solutions.singleton.parameter;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonUserTest {

	private LazySingleton lazy = new LazySingleton();
	private EagerSingleton eager = new EagerSingleton();

	@Test
	public void testDoSomething() {
		// arrange
		SingletonUser testee = new SingletonUser(eager, lazy);
		// act
		testee.doSomething();
		// assert
		assertThat(lazy.getCounter()).isEqualTo(1);
		assertThat(eager.getCounter()).isEqualTo(1);
	}

	@Test
	public void testDoSomething2() {
		// arrange
		SingletonUser testee = new SingletonUser(eager, lazy);
		// act
		testee.doSomething();
		// assert
		assertThat(lazy.getCounter()).isEqualTo(1);
		assertThat(eager.getCounter()).isEqualTo(1);
	}
}
