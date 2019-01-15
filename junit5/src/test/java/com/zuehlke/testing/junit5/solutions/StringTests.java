package com.zuehlke.testing.junit5.solutions;

public class StringTests implements HashCodeContract<String> {
    @Override
    public String createValue() {
        return "Hello World!";
    }

    @Override
    public String createDifferentValue() {
        return "Hello JUnit 5!";
    }
}
