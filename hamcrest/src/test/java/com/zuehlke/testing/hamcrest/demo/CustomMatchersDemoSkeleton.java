package com.zuehlke.testing.hamcrest.demo;

import com.zuehlke.testing.hamcrest.Person;
import org.hamcrest.Matcher;

public class CustomMatchersDemoSkeleton {
    public static Matcher<Person> hasAge(final int i) {
        return null;
    }

    public static Matcher<Person> hasAgeFeatureMatcher(final Integer i) {
        return null;
    }
}
