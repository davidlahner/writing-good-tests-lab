package com.zuehlke.testing.tdd.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,Fizz", "5,Buzz", "6,Fizz", "10,Buzz",
            "15,FizzBuzz", "30,FizzBuzz"})
    void convertInput(int input, String expected) {
        FizzBuzz testee = new FizzBuzz();
        String result = testee.convertInput(input);

        assertEquals(expected, result);
    }

    private class FizzBuzz {
        public String convertInput(int i) {
            if (isMultipleOf3(i) && isMultipleOf5(i)) {
                return "FizzBuzz";
            }
            if (isMultipleOf5(i)) {
                return "Buzz";
            }
            if (isMultipleOf3(i)) {
                return "Fizz";
            }
            return String.valueOf(i);
        }

        private boolean isMultipleOf5(int i) {
            return i % 5 == 0;
        }

        private boolean isMultipleOf3(int i) {
            return i % 3 == 0;
        }
    }
}
