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

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;
import static org.junit.jupiter.params.provider.EnumSource.Mode.MATCH_ALL;

class ParameterizedTests {

    @ParameterizedTest
    @ValueSource(strings = { "Hello", "World" })
    void testWithStringParameter(String argument) {
        assertNotNull(argument);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void testWithValueSource(int argument) {
        assertTrue(argument > 0);
    }

    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void testWithEnumSource(TimeUnit timeUnit) {
        assertNotNull(timeUnit);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = { "DAYS", "HOURS" })
    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EXCLUDE, names = { "DAYS", "HOURS" })
    void testWithEnumSourceExclude(TimeUnit timeUnit) {
        assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
        assertTrue(timeUnit.name().length() > 5);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = MATCH_ALL, names = "^(M|N).+SECONDS$")
    void testWithEnumSourceRegex(TimeUnit timeUnit) {
        String name = timeUnit.name();
        assertTrue(name.startsWith("M") || name.startsWith("N"));
        assertTrue(name.endsWith("SECONDS"));
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithSimpleMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("foo", "bar");
    }

    @ParameterizedTest
    @MethodSource("range")
    void testWithRangeMethodSource(int argument) {
        assertNotEquals(9, argument);
    }

    static IntStream range() {
        return IntStream.range(0, 20).skip(10);
    }

    @ParameterizedTest
    @MethodSource("stringAndIntProvider")
    void testWithMultiArgMethodSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }

    static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(Arguments.of("foo", 1), Arguments.of("bar", 2));
    }

    @ParameterizedTest
    @CsvSource({"'Hello foo!', 1", "bar, 2"})
    void testWithCsvSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }

    @ParameterizedTest
    @CsvSource({"true, 3.14159265359, AUGUST, 2018, 23.08.2018"})
    void testDefaultConverters(
            boolean b, double d, Summer s, Year y,
            @JavaTimeConversionPattern("dd.MM.yyyy") LocalDate dt) { }

    enum Summer {
        JUNE, JULY, AUGUST, SEPTEMBER;
    }

    @ParameterizedTest
    @CsvSource({ "0, 0, 0", "1, 0, 1", "1.414, 1, 1" })
    void testPointNorm(double norm, ArgumentsAccessor arguments) {
        Point point = new Point(
                arguments.getInteger(1), arguments.getInteger(2));
        /*...*/
    }

    @ParameterizedTest
    @CsvSource({ "0, 0, 0", "1, 0, 1", "1.414, 1, 1" })
    void testPointNorm(
            double norm,
            @AggregateWith(PointAggregator.class) Point point) {
        /*...*/
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
