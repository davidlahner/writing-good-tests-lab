package com.zuehlke.testing.junit5.solutions;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

class TimeoutTest {

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            /* do something */
            Thread.sleep(1002);
        });
    }

    /**
     * assertTimeout measures time in milliseconds. So if we set the timeout to Duration.ZERO
     * and execute code that is faster than 1 millisecond then the test will pass.
     */
    @Test
    void testTimeout_withDurationZero() {
        assertTimeout(Duration.ZERO, () -> {
            /* do something */
            Thread.sleep(1);
        });
    }
}
