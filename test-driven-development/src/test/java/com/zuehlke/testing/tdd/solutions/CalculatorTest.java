package com.zuehlke.testing.tdd.solutions;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private Calculator testee = new Calculator();

	@Test
	public void testCalculate_emptyString_0() {
		// act
		int sum = testee.calculate("");
		// assert
		assertThat(sum, is(equalTo(0)));
	}

	@Test
	public void testCalculate_oneNumber_number() {
		// act
		int sum = testee.calculate("1");
		// assert
		assertThat(sum, is(equalTo(1)));
	}

	@Test
	public void testCalculate_twoNumbers_sum() {
		// act
		int sum = testee.calculate("1,2");
		// assert
		assertThat(sum, is(equalTo(3)));
	}

	@Test
	public void testCalculate_threeNumbers_sum() {
		// act
		int sum = testee.calculate("1,2,5");
		// assert
		assertThat(sum, is(equalTo(8)));
	}

	@Test
	public void testCalculate_fourNumbers_exception() {
		// act
		assertThrows(IllegalArgumentException.class, () -> testee.calculate("1,2,5,6"));
	}
}
