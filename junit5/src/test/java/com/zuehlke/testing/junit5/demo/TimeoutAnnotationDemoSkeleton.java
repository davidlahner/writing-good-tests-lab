package com.zuehlke.testing.junit5.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TimeoutAnnotationDemoSkeleton {


    @Test
    void timeoutNotExceeded() {

    }

    @Disabled
    @Test
    void timeoutExceeded() throws InterruptedException {
        // Simulate task that takes more than 10 ms.
        Thread.sleep(100);
    }

}
