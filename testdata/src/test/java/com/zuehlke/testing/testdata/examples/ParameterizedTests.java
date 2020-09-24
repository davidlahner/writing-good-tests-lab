package com.zuehlke.testing.testdata.examples;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.*;

import java.awt.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;
import static org.junit.jupiter.params.provider.EnumSource.Mode.MATCH_ALL;

class ParameterizedTests {

    static Stream<String> stringProvider() {
        return Stream.of("foo", "bar");
    }

    static IntStream range() {
        return IntStream.range(0, 20).skip(10);
    }

    static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(Arguments.of("foo", 1), Arguments.of("bar", 2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    void testWithStringParameter(String argument) {
        assertThat(argument).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithValueSource(int argument) {
        assertThat(argument).isGreaterThan(0);
    }

    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void testWithEnumSource(TimeUnit timeUnit) {
        assertThat(timeUnit).isNotNull();
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        assertThat(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS)).contains(timeUnit);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EXCLUDE, names = {"DAYS", "HOURS"})
    void testWithEnumSourceExclude(TimeUnit timeUnit) {
        assertThat(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS)).doesNotContain(timeUnit);
        assertThat(timeUnit.name().length()).isGreaterThan(5);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = MATCH_ALL, names = "^(M|N).+SECONDS$")
    void testWithEnumSourceRegex(TimeUnit timeUnit) {
        String name = timeUnit.name();
        assertThat(name.startsWith("M") || name.startsWith("N")).isTrue();
        assertThat(name).endsWith("SECONDS");
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithSimpleMethodSource(String argument) {
        assertThat(argument).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("range")
    void testWithRangeMethodSource(int argument) {
        assertThat(argument).isNotEqualTo(9);
    }

    @ParameterizedTest
    @MethodSource("stringAndIntProvider")
    void testWithMultiArgMethodSource(String first, int second) {
        assertThat(first).isNotNull();
        assertThat(second).isNotEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"'Hello foo!', 1", "bar, 2"})
    void testWithCsvSource(String first, int second) {
        assertThat(first).isNotNull();
        assertThat(second).isNotEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"true, 3.14159265359, AUGUST, 2018, 23.08.2018"})
    void testDefaultConverters(
            boolean b, double d, Summer s, Year y,
            @JavaTimeConversionPattern("dd.MM.yyyy") LocalDate dt) {
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 0", "1, 0, 1", "1.414, 1, 1"})
    void testPointNorm(double norm, ArgumentsAccessor arguments) {
        Point point = new Point(
                arguments.getInteger(1), arguments.getInteger(2));
        /*...*/
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 0", "1, 0, 1", "1.414, 1, 1"})
    void testPointNorm(
            double norm,
            @AggregateWith(PointAggregator.class) Point point) {
        /*...*/
    }

    enum Summer {
        JUNE, JULY, AUGUST, SEPTEMBER;
    }

    static class PointAggregator implements ArgumentsAggregator {

        @Override
        public Object aggregateArguments(
                ArgumentsAccessor arguments, ParameterContext context)
                throws ArgumentsAggregationException {
            return new Point(
                    arguments.getInteger(1), arguments.getInteger(2));
        }
    }
}
