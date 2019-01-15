package com.zuehlke.testing.hamcrest.examples;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Description;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import com.zuehlke.testing.hamcrest.Person;

//inspired by https://www.planetgeek.ch/2012/03/07/create-your-own-matcher/
public class CustomMatchers {

	public static Matcher<Person> hasAge(final int i) {
		return new TypeSafeDiagnosingMatcher<Person>() {
			@Override
			public void describeTo(final Description description) {
				description.appendText("getNumber should return ") //
						.appendValue(i);
			}

			@Override
			protected boolean matchesSafely(final Person item, //
					final Description mismatchDescription) {
				mismatchDescription.appendText(" was ") //
						.appendValue(item.getAge());
				return i == item.getAge();
			}
		};
	}

	public static Matcher<Person> hasAgeFeatureMatcher( //
			final Integer i) {
		return new FeatureMatcher<Person, Integer>( //
				equalTo(i), "age", "age") {
			@Override
			protected Integer featureValueOf( //
					final Person actual) {
				return actual.getAge();
			}
		};
	}
}
