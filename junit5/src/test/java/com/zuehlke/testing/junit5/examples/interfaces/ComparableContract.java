package com.zuehlke.testing.junit5.examples.interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public interface ComparableContract<T extends Comparable<T>> extends Testable<T> {
    T createSmallerValue();

    @Test
    default void compareToItselfReturnsZero() {
        T value = createValue();
        assertEquals(0, value.compareTo(value));
    }

    @Test
    default void compareToSmallerValueReturnsPositiveNumber() {
        T value = createValue();
        T smallerValue = createSmallerValue();
        assertTrue(value.compareTo(smallerValue) > 0);
    }

    @Test
    default void compareToLargerValueReturnsNegativeNumber() {
        T value = createValue();
        T smallerValue = createSmallerValue();
        assertTrue(smallerValue.compareTo(value) < 0);
    }

}
