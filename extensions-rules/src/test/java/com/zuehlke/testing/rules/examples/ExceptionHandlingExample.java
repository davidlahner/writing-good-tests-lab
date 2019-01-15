package com.zuehlke.testing.rules.examples;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.zuehlke.testing.rules.Person;

public class ExceptionHandlingExample {

	@Test
	public void invalidArgument_oldStyle() {
		try {
			new Person(null);
			// don't forget to fail if no exception is thrown
			Assert.fail("expected an exception");
		} catch (IllegalArgumentException ex) {
			assertThat("message", ex.getMessage(), is(equalTo("Name must not be null")));
		}
	}

	@Test
	void invalidArgument_junit5() {
		// act
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> new Person(null));

		//assert
		assertThat("message", ex.getMessage(),
				is(equalTo("Name must not be null")));
	}
}
