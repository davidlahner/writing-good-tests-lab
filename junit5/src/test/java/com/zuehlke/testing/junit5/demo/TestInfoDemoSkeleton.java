package com.zuehlke.testing.junit5.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("TestInfo Demo")
class TestInfoDemoSkeleton {


    @BeforeEach
    void init() {
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    void test1() {
    }

    @Test
    void test2() {
    }

}
