package com.zuehlke.testing.junit5.solutions;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTimeout;

class TimeoutTest {

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofSeconds(5), () -> { /* do something */});
    }
}
