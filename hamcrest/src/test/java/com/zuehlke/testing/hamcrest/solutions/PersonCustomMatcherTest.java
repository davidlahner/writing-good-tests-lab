package com.zuehlke.testing.hamcrest.solutions;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import com.zuehlke.testing.hamcrest.Person;

public class PersonCustomMatcherTest {

	@Test
	public void constructor_parametersGiven_initializedPerson() {
		// act
		Person result = new Person(1, "Peter", "Maler", 42);

		// assert
		assertThat(result, allOf(hasFirstName("Peter"), hasLastName("Maler")));
	}

	private Matcher<Person> hasFirstName(String expected) {
		return new FeatureMatcher<Person, String>(equalTo(expected), "firstName", "firstName") {

			@Override
			protected String featureValueOf(Person actual) {
				return actual.getFirstname();
			}
		};
	}

	private Matcher<Person> hasLastName(String expected) {
		return new FeatureMatcher<Person, String>(equalTo(expected), "lastName", "lastName") {

			@Override
			protected String featureValueOf(Person actual) {
				return actual.getLastname();
			}
		};
	}
}
