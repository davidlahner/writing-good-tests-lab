package com.zuehlke.testing.junit5.solutions;

import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParameterizedInfoAndReporterTest {

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    void testWithAdditionalParameters(String argument, TestInfo info, TestReporter reporter) {
        assertNotNull(argument);
        assertThat(info.getDisplayName()).contains("o");
        reporter.publishEntry("Test Name", info.getDisplayName());
    }

}
