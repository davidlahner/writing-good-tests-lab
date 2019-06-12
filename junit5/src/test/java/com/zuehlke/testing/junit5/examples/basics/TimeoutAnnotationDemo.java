package com.zuehlke.testing.junit5.examples.basics;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class TimeoutAnnotationDemo {


    @Test
    // default time unit is TimeUnit.SECONDS
    @Timeout(value = 2)
    void timeoutNotExceeded() {

    }

    @Disabled
    //TODO: remove @Disabled to run test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @Test
    void timeoutExceeded() throws InterruptedException {
        // Simulate task that takes more than 10 ms.
        Thread.sleep(100);
    }

    private static String greeting() {
        return "hello world!";
    }
}
