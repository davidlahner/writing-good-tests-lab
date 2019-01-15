package com.zuehlke.testing.basics.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstJUnit5Test {

    @Test
    void myFirstTest() {
        assertEquals(2, add(1,1));
    }

    @Test
    void assertionWithMessage() {
        assertEquals(5, add(2,3), "2 and 3 should be 5");
    }

    @Test
    void assertionWithStringSupplier() {
        assertEquals(5, add(2,3), () -> message(5));
    }

    private String message(int value) {
        return "expected: " + value;
    }

    private int add(int first, int second) {
        return first + second;
    }
}
