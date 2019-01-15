package com.zuehlke.testing.solutions.singleton.parameter;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

import com.zuehlke.testing.solutions.singleton.parameter.EagerSingleton;
import com.zuehlke.testing.solutions.singleton.parameter.LazySingleton;
import com.zuehlke.testing.solutions.singleton.parameter.SingletonUser;

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
		assertThat(lazy.getCounter(), is(equalTo(1)));
		assertThat(eager.getCounter(), is(equalTo(1)));
	}

	@Test
	public void testDoSomething2() {
		// arrange
		SingletonUser testee = new SingletonUser(eager, lazy);
		// act
		testee.doSomething();
		// assert
		assertThat(lazy.getCounter(), is(equalTo(1)));
		assertThat(eager.getCounter(), is(equalTo(1)));
	}
}
