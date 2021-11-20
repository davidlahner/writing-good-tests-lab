package com.zuehlke.testing.junit5.demo;

import org.junit.jupiter.api.Test;

public class TimeoutAssertionsDemoSkeleton {

    @Test
    void timeoutNotExceeded() {
        // The following assertion succeeds.

    }


    @Test
    void timeoutNotExceededWithResult() {
        // The following assertion succeeds, and returns the supplied object.
    }


    @Test
    void timeoutExceeded() {
        // The following assertion fails with an error message similar to:
    }
    

    private static String greeting() {
        return "hello world!";
    }
}
