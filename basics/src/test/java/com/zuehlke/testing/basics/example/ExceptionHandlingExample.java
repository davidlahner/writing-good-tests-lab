package com.zuehlke.testing.basics.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionHandlingExample {

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void invalidArgument_oldStyle_withAnnotationParameter() {
        new Person(null);
    }

    @org.junit.Test
    public void invalidArgument_oldStyle() {
        try {
            new Person(null);
            // don't forget to fail if no exception is thrown
            Assert.fail("expected an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("message", "Name must not be null", ex.getMessage());
        }
    }

    @Test
    void invalidArgument_junit5() {
        // act
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Person(null));

        //assert
        assertThat("message", ex.getMessage(),
                is(equalTo("Name must not be null")));
    }
}
