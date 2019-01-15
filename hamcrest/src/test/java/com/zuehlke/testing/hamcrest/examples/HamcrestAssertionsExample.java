package com.zuehlke.testing.hamcrest.examples;

import static com.zuehlke.testing.hamcrest.examples.CustomMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.zuehlke.testing.hamcrest.Person;

public class HamcrestAssertionsExample {

	private Person han = new Person(1, "Han", "Solo", 29);
	private Person leia = new Person(2, "Leia", "Organa", 19);
	private Person luke = new Person(3, "Luke", "Skywalker", 19);

	@Test
	public void matchingStrings() {
		String value = "String";
		assertThat(value, equalTo("String"));
		assertThat(value, not(sameInstance(new String("String"))));
		assertThat(value, not("Dummy"));
		assertThat(value, notNullValue());
		assertThat(value, containsString("ing"));
		assertThat(value, instanceOf(String.class));
		assertThat(value, isA(String.class));
	}

	@Test
	public void equivalentMatchers() {
		boolean a = true;
		boolean b = true;

		assertThat(a, equalTo(b));
		assertThat(a, is(equalTo(b)));
		assertThat(a, is(b));
	}

	@Test
	public void collectionMatchers() {
		// act
		List<Person> characters = Arrays.asList(han, leia, luke);

		// assert

		// search in collection
		assertThat(characters, hasItem(luke));

		// further collection assertions
		assertThat(characters, contains(han, leia, luke));
		assertThat(characters, containsInAnyOrder(leia, han, luke));
	}

	@Disabled
	@Test
	public void personEqual() {
		Person leia2 = new Person(2, "Leia", "Organa", 19);
		assertThat(leia, is(equalTo(leia2)));
	}

	@Test
	public void personEqualsSamePropertyValues() {
		Person leia2 = new Person(2, "Leia", "Organa", 19);
		assertThat(leia, samePropertyValuesAs(leia2));
	}

	@Test
	public void customMatcher() {
		assertThat(leia, hasAge(19));
	}

	@Test
	public void customFeatureMatcher() {
		assertThat(leia, hasAgeFeatureMatcher(19));
		assertThat(han, hasAgeFeatureMatcher(29));
	}
}
