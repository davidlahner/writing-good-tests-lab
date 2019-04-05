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
}
