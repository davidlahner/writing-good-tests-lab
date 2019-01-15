package com.zuehlke.testing.hamcrest.examples;

import com.zuehlke.testing.hamcrest.Person;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
//TODO: remove @Disabled to run test
public class ErrorMessagesExample {

    private final Person mike = new Person(1, "Mike", "Tester", 38);

    @Test
    public void errorMessageJUnit() {
        assertTrue(mike.getAge() > 30 && mike.getAge() % 2 != 0);
    }

    @Test
    public void errorMessageJUnitWithMessage() {
        assertTrue(mike.getAge() > 30 && mike.getAge() % 2 != 0, "age>30 and odd");
    }

    @Test
    public void errorMessageJUnitWithAssertAll() {
        assertAll("mike",
                () -> assertTrue(mike.getAge() > 30, "age > 30"),
                () -> assertTrue(mike.getAge()  % 2 != 0, "age odd")
        );
    }

    @Test
    public void errorMessageHamcrest() {
        assertThat(mike.getAge(),
                allOf(greaterThan(30), not(evenNumber())));
    }

    private static Matcher<Integer> evenNumber() {
        return new TypeSafeDiagnosingMatcher<Integer>() {
            @Override
            public void describeTo(final Description description) {
                description.appendText("even number");
            }

            @Override
            protected boolean matchesSafely(final Integer item, //
                                            final Description mismatchDescription) {
                mismatchDescription.appendText(" was ") //
                        .appendValue(item);
                return item % 2 == 0;
            }
        };
    }


}
