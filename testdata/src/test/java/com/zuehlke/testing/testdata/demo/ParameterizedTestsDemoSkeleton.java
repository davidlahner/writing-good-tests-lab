package com.zuehlke.testing.testdata.demo;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("unused")
public class ParameterizedTestsDemoSkeleton {

    enum Summer {
        JUNE, JULY, AUGUST, SEPTEMBER
    }

    void testWithStringParameter(String argument) {
        assertThat(argument).isNotNull();
    }


    void testWithValueSource(int argument) {
        assertThat(argument).isGreaterThan(0);
    }


    void testWithEnumSource(TimeUnit timeUnit) {
        assertThat(timeUnit).isNotNull();
    }


    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        assertThat(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS)).contains(timeUnit);
    }


    void testWithEnumSourceExclude(TimeUnit timeUnit) {
        assertThat(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS)).doesNotContain(timeUnit);
        assertThat(timeUnit.name().length()).isGreaterThan(5);
    }


    void testWithEnumSourceRegex(TimeUnit timeUnit) {
        String name = timeUnit.name();
        assertThat(name.startsWith("M") || name.startsWith("N")).isTrue();
        assertThat(name).endsWith("SECONDS");
    }


    void testWithSimpleMethodSource(String argument) {
        assertThat(argument).isNotNull();
    }


    void testWithRangeMethodSource(int argument) {
        assertThat(argument).isNotEqualTo(9);
    }


    void testWithMultiArgMethodSource(String first, int second) {
        assertThat(first).isNotNull();
        assertThat(second).isNotEqualTo(0);
    }


    void testWithCsvSource(String first, int second) {
        assertThat(first).isNotNull();
        assertThat(second).isNotEqualTo(0);
    }

}
