package com.zuehlke.testing.junit5.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssumptionsDemoSkeleton {
    @Test
    void testOnlyOnCiServer() {
        // remainder of test
    }

    
    @Test
    void testOnlyOnDeveloperWorkstation() {
        // remainder of test
    }


    @Test
    void testInAllEnvironments() {

        // perform these assertions in all environments
        assertEquals("a string", "a string");
    }

}
