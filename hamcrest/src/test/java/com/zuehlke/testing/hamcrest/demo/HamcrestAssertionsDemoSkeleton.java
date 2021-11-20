package com.zuehlke.testing.hamcrest.demo;

import com.zuehlke.testing.hamcrest.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HamcrestAssertionsDemoSkeleton {

    private final Person han = new Person(1, "Han", "Solo", 29);
    private final Person leia = new Person(2, "Leia", "Organa", 19);
    private final Person luke = new Person(3, "Luke", "Skywalker", 19);

    @Test
    public void matchingStrings() {
        String value = "String";
    }

    @Test
    public void equivalentMatchers() {
        boolean a = true;
        boolean b = true;

    }

    @Test
    public void collectionMatchers() {
        // act
        List<Person> characters = Arrays.asList(han, leia, luke);

        // assert

        // search in collection

        // further collection assertions
    }

    @Test
    public void personEqual() {
        Person leia2 = new Person(2, "Leia", "Organa", 19);
    }

    @Test
    public void customMatcher() {
    }

    @Test
    public void customFeatureMatcher() {
    }
}
