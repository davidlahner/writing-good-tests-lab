package com.zuehlke.testing.hamcrest.demo;

import com.zuehlke.testing.hamcrest.Person;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.jupiter.api.Test;

public class ErrorMessagesDemoSkeleton {
    private final Person mike = new Person(1, "Mike", "Tester", 38);

    @Test
    public void errorMessageJUnit() {
    }

    @Test
    public void errorMessageJUnitWithMessage() {
    }

    @Test
    public void errorMessageJUnitWithAssertAll() {
    }

    @Test
    public void errorMessageHamcrest() {
    }

    private static Matcher<Integer> evenNumber() {
        return new TypeSafeDiagnosingMatcher<>() {
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
