package com.zuehlke.testing.hamcrest.examples;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class MatcherTest {
    private Set<String> set = Set.of("Hello", "World", "Test");
    private Set<String> set2 = Set.of("Hello", "World", "Test");

    @Test
    void testSet() {

        assertThat(set, contains("Hello", "Test", "World"));
        assertThat(set, is(equalTo(set2)));
    }
}
