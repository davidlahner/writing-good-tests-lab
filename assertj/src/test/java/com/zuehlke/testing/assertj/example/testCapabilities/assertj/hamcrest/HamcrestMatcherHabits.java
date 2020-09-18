package com.zuehlke.testing.assertj.example.testCapabilities.assertj.hamcrest;

import org.assertj.core.api.Condition;
import org.assertj.core.matcher.AssertionMatcher;

import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

public interface HamcrestMatcherHabits {

    default <T> AssertionMatcher<T> satisfies(Consumer<T> requirements) {
        return new AssertionMatcher<>() {

            @Override
            public void assertion(T actual) throws AssertionError {
                assertThat(actual).satisfies(requirements);
            }
        };
    }

    default <T> AssertionMatcher<T> is(Condition<T> condition) {
        return new AssertionMatcher<>() {

            @Override
            public void assertion(T actual) throws AssertionError {
                assertThat(actual).is(condition);
            }
        };
    }

    default <T> AssertionMatcher<T> satisfies(Class<T> expectedType, Consumer<T> requirements) {
        return new AssertionMatcher<>() {

            @Override
            public void assertion(T actual) throws AssertionError {
                assertThat(actual).isInstanceOfSatisfying(expectedType, requirements);
            }
        };

    }

    @SuppressWarnings("unchecked")
    default <T> AssertionMatcher<List<T>> contains(T... expected) {
        return satisfies((List<T> actual) ->
                assertThat(actual).contains(expected));
    }

}
