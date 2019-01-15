package com.zuehlke.testing.junit5.examples.mixingversions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JupiterTestsDemo {


    @Test
    void junit5Test() {
        Assertions.assertEquals(2, 1+1);
    }
}
