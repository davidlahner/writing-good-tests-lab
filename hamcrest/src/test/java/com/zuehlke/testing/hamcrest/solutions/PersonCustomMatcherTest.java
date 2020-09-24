package com.zuehlke.testing.hamcrest.solutions;

import com.zuehlke.testing.hamcrest.Person;
import org.hamcrest.Description;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;

class PersonCustomMatcherTest {

    @Test
    void constructor_parametersGiven_initializedPerson() {
        // act
        Person result = new Person(1, "Peter", "Maler", 42);

        // assert
        assertThat(result, allOf(hasFirstName("Peter"), hasLastName("Maler")));
    }

    private Matcher<Person> hasFirstName(String expected) {
        return new TypeSafeDiagnosingMatcher<>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("first name should be ").appendValue(expected);
            }

            @Override
            protected boolean matchesSafely(Person item, Description mismatchDescription) {
                mismatchDescription.appendText("was ").appendValue(item.getFirstname());
                return expected.equals(item.getFirstname());
            }
        };
    }

    private Matcher<Person> hasLastName(String expected) {
        return new FeatureMatcher<>(equalTo(expected), "lastName", "lastName") {

            @Override
            protected String featureValueOf(Person actual) {
                return actual.getLastname();
            }
        };
    }
}
