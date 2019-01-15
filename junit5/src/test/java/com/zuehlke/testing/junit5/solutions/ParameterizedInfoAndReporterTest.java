package com.zuehlke.testing.junit5.solutions;

import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;
import static org.junit.jupiter.params.provider.EnumSource.Mode.MATCH_ALL;

class ParameterizedInfoAndReporterTest {

    @ParameterizedTest
    @ValueSource(strings = { "Hello", "World" })
    void testWithAdditionalParameters(String argument, TestInfo info, TestReporter reporter) {
        assertNotNull(argument);
        assertThat(info.getDisplayName(), containsString("o"));
        reporter.publishEntry("Test Name", info.getDisplayName());
    }

}
