package com.zuehlke.testing.assertj.example;

import com.zuehlke.testing.assertj.example.domain.people.Person;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertjAssertionsExample {

	private final Person han = new Person("Han", "Solo", 29);
	private final Person leia = new Person("Leia", "Organa", 19);
	private final Person luke = new Person("Luke", "Skywalker", 19);

	@Test
	public void matchingStrings() {
		String value = "String";
		assertThat(value).isEqualTo("String");
		assertThat(value).isNotSameAs(new String("String"));
		assertThat(value).isNotEqualTo("Dummy");
		assertThat(value).isNotNull();
		assertThat(value).isNotBlank();
		assertThat(value).contains("ing");
		assertThat(value).isInstanceOf(String.class);
	}

	@Test
	public void equivalentMatchers() {
		boolean a = true;
		boolean b = true;

		assertThat(a).isEqualTo(b);
		assertThat(a).isTrue();
	}

	@Test
	public void collectionMatchers() {
		// act
		List<Person> characters = Arrays.asList(han, leia, luke);

		// assert

		// search in collection
		assertThat(characters).contains(luke);

		// further collection assertions
		assertThat(characters).contains(han, leia, luke);
		assertThat(characters).containsExactlyInAnyOrder(leia, han, luke);
	}

	@Disabled
	@Test
	public void personEqual() {
		Person leia2 = new Person("Leia", "Organa", 19);
		assertThat(leia).isEqualTo(leia2);
	}

	@Test
	public void personEqualsSamePropertyValues() {
		Person leia2 = new Person("Leia", "Organa", 19);
		assertThat(leia).usingRecursiveComparison().isEqualTo(leia2);
	}
}
