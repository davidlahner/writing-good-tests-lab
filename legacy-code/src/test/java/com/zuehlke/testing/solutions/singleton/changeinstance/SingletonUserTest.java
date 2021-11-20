package com.zuehlke.testing.solutions.singleton.changeinstance;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		assertThat(LazySingleton.getInstance().getCounter(), is(equalTo(1)));
		assertThat(EagerSingleton.getInstance().getCounter(), is(equalTo(1)));
	}

	@Test
	public void testDoSomething2() {
		// arrange
		SingletonUser testee = new SingletonUser();
		// act
		testee.doSomething();
		// assert
		assertThat(LazySingleton.getInstance().getCounter(), is(equalTo(1)));
		assertThat(EagerSingleton.getInstance().getCounter(), is(equalTo(1)));
	}
}
