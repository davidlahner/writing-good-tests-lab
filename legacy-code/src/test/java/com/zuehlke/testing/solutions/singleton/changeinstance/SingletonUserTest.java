package com.zuehlke.testing.solutions.singleton.changeinstance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonUserTest {
	private LazySingleton lazy = new LazySingleton();
	private EagerSingleton eager = new EagerSingleton();

	@BeforeEach
	public void initSingletons() {
		LazySingleton.setInstance(lazy);
		EagerSingleton.setInstance(eager);
	}

	@Test
	public void testDoSomething() {
		// arrange
		SingletonUser testee = new SingletonUser();
		// act
		testee.doSomething();
		// assert
		assertThat(LazySingleton.getInstance().getCounter()).isEqualTo(1);
		assertThat(EagerSingleton.getInstance().getCounter()).isEqualTo(1);
	}

	@Test
	public void testDoSomething2() {
		// arrange
		SingletonUser testee = new SingletonUser();
		// act
		testee.doSomething();
		// assert
		assertThat(LazySingleton.getInstance().getCounter()).isEqualTo(1);
		assertThat(EagerSingleton.getInstance().getCounter()).isEqualTo(1);
	}
}
