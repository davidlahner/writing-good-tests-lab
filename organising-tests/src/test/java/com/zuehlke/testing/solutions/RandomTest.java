package com.zuehlke.testing.solutions;

import org.junit.jupiter.api.Test;

/*
 * add the following to build.gradle
  test {
    useJUnitPlatform {
        includeTags 'superFast'
    }
  }
 */
public class RandomTest {

    @SuperFast
    //@Tag("SuperFast")
    @Test
    public void test() {
    }
}
