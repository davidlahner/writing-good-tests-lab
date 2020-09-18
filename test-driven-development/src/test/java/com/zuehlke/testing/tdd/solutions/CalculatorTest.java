package com.zuehlke.testing.tdd.solutions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private Calculator testee = new Calculator();

    @Test
    void testCalculate_emptyString_0() {
        // act
        int sum = testee.calculate("");
        // assert
        assertThat(sum, is(equalTo(0)));
    }

    @Test
    void testCalculate_oneNumber_number() {
        // act
        int sum = testee.calculate("1");
        // assert
        assertThat(sum, is(equalTo(1)));
    }

    @Test
    void testCalculate_twoNumbers_sum() {
        // act
        int sum = testee.calculate("1,2");
        // assert
        assertThat(sum, is(equalTo(3)));
    }

    @Test
    void testCalculate_threeNumbers_throwsException() {
        // act
        assertThrows(IllegalArgumentException.class,
                () -> testee.calculate("1,2,5"));
    }

    @ParameterizedTest
    @CsvSource({"'',0", "1,1", "'1,2',3"})
    void testCalculate(String input, int expected) {
        int sum = testee.calculate(input);
        assertThat(sum, is(equalTo(expected)));
    }
}
