package com.zuehlke.testing.junit5.solutions;

import com.zuehlke.testing.junit5.examples.interfaces.Testable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public interface HashCodeContract<T> extends Testable<T> {
    T createDifferentValue();

    @Test
    default void sameValue_HashCodeIdentical() {
        assertEquals(createValue().hashCode(), createValue().hashCode());
    }

    @Test
    default void differentValue_HashCodeDifferent() {
        assertNotEquals(createValue().hashCode(), createDifferentValue().hashCode());
    }
}
