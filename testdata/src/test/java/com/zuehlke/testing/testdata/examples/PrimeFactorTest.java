package com.zuehlke.testing.testdata.examples;

import com.zuehlke.testing.testdata.PrimeFactor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PrimeFactorTest {

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void primeFactors(int product, List<Integer> factors) {
        // act
        List<Integer> result = PrimeFactor.factorsOf(product);
        // arrange
        assertThat(result).isEqualTo(factors);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(1, Arrays.asList()), //
                arguments(2, Arrays.asList(2)), //
                arguments(3, Arrays.asList(3)), //
                arguments(4, Arrays.asList(2, 2)), //
                arguments(5, Arrays.asList(5)), //
                arguments(6, Arrays.asList(2, 3)), //
                arguments(7, Arrays.asList(7)), //
                arguments(8, Arrays.asList(2, 2, 2)), //
                arguments(9, Arrays.asList(3, 3)), //
                arguments(10, Arrays.asList(2, 5)), //
                arguments(12, Arrays.asList(2, 2, 3)), //
                arguments(16, Arrays.asList(2, 2, 2, 2)), //
                arguments(18, Arrays.asList(2, 3, 3)), //
                arguments(26, Arrays.asList(2, 13)), //
                arguments(99, Arrays.asList(3, 3, 11)), //
                arguments(101, Arrays.asList(101)) //
        );
    }

}
