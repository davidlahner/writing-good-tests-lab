package com.zuehlke.testing.assertj.example.testCapabilities.hamcrest.matchers;

import com.google.gson.Gson;
import com.zuehlke.testing.assertj.example.domain.people.Person;
import com.zuehlke.testing.assertj.example.testCapabilities.assertj.assertions.PersonTestHabits;
import org.hamcrest.*;

import static org.hamcrest.Matchers.equalTo;

public interface PersonHamcrestTestHabits {

    default Matcher<Person> havingFirstName(String expectedFirstName) {
        return new FeatureMatcher<>(equalTo(expectedFirstName), "first name", "first name") {
            @Override
            protected String featureValueOf(Person actual) {
                return actual.getFirstName();
            }
        };
    }

    default Matcher<Person> havingLastName(String expectedFirstName) {
        return new FeatureMatcher<>(equalTo(expectedFirstName), "last name", "last name") {
            @Override
            protected String featureValueOf(Person actual) {
                return actual.getLastName();
            }
        };
    }

    default Matcher<Person> aPersonNamed(String firstName, String lastName) {
        return Matchers.allOf(havingFirstName(firstName), havingLastName(lastName));
    }

    default Matcher<Person> aged(int expected) {
        return new FeatureMatcher<>(equalTo(expected), "age", "age") {
            @Override
            protected Integer featureValueOf(Person actual) {

                return actual.getAge();
            }
        };
    }

    default Matcher<Person> anAdult() {
        int ADULT_AGE = 18;

        return new TypeSafeDiagnosingMatcher<>() {
            @Override
            protected boolean matchesSafely(Person thePerson, Description mismatchDescription) {

                int theAge = thePerson.getAge();

                mismatchDescription.appendText(" age of ")
                        .appendText(thePerson.toString())
                        .appendText(" was ")
                        .appendValue(theAge);

                return theAge >= ADULT_AGE;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("an adult and must be at least " + ADULT_AGE + " years old");
            }
        };
    }

    default PersonTestHabits.PersonJson parsePersonFromJson(String json) {
        return new Gson().fromJson(json, PersonTestHabits.PersonJson.class);
    }
}
