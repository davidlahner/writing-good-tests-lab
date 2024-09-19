package com.zuehlke.testing.examples.singleton;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
