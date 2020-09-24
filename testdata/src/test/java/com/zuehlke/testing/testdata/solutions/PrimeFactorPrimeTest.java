package com.zuehlke.testing.testdata.solutions;

import com.zuehlke.testing.testdata.PrimeFactor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PrimeFactorPrimeTest {

    @DisplayName("is Prime with CsvSource")
    @ParameterizedTest(name = "result for \"{0}\" should be {1}")
    @CsvSource({"1, false ", "2, true ", "3, true ", "4, false ", "5, true ", "6, false ", "7, true ", "8, false ", //
            "26, false ", "99, false ", "101, true ", "102, false "})
    void isPrimeCsvSource(int number, boolean primeExpected) {
        // act
        boolean result = PrimeFactor.isPrime(number);
        // assert
        assertThat(result).isEqualTo(primeExpected);
    }

    @DisplayName("is Prime with MethodSource")
    @ParameterizedTest(name = "result for \"{0}\" should be {1}")
    @MethodSource("argumentsProvider")
    void isPrimeMethodSource(int number, boolean primeExpected) {
        // act
        boolean result = PrimeFactor.isPrime(number);
        // assert
        assertThat(result).isEqualTo(primeExpected);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(1, false), //
                arguments(2, true), //
                arguments(3, true), //
                arguments(4, false), //
                arguments(5, true), //
                arguments(6, false), //
                arguments(7, true), //
                arguments(8, false), //
                arguments(26, false), //
                arguments(99, false), //
                arguments(101, true), //
                arguments(102, false) //
        );
    }

}
