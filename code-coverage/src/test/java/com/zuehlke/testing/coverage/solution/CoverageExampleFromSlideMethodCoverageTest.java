package com.zuehlke.testing.coverage.solution;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.zuehlke.testing.coverage.example.CoverageExampleFromSlide;

class CoverageExampleFromSlideMethodCoverageTest {

	private CoverageExampleFromSlide testee = new CoverageExampleFromSlide();

	@Test
	// Achieves 100% method coverage
	void testIsShopOpen_9am_open() {
		// act
		boolean result = testee.isShopOpen(LocalTime.of(9, 00), false);

		// assert
		assertThat(result, is(true));
	}
}
