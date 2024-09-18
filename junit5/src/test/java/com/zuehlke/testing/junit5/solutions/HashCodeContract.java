package com.zuehlke.testing.junit5.solutions;

import com.zuehlke.testing.junit5.examples.interfaces.Testable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public interface HashCodeContract<T> extends Testable<T> {
    T createDifferentValue();

    @Test
    default void sameValue_HashCodeIdentical() {
        assertThat(createValue()).hasSameHashCodeAs(createValue());
    }

    @Test
    default void differentValue_HashCodeDifferent() {
        assertThat(createValue()).doesNotHaveSameHashCodeAs(createDifferentValue());
    }
}
