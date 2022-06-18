package com.zuehlke.testing.hamcrest.examples;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MatcherTest {
    private final Set<String> set = Set.of("Hello", "World", "Test");
    private final Set<String> set2 = Set.of("Hello", "World", "Test");

    @Test
    void testSet() {

        assertThat(set, containsInAnyOrder("Hello", "Test", "World"));
        assertThat(set, is(equalTo(set2)));
    }
}
