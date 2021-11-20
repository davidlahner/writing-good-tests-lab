package com.zuehlke.testing.examples.singleton;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
//TODO: remove @Disabled to run test
public class SingletonUserTest {

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
