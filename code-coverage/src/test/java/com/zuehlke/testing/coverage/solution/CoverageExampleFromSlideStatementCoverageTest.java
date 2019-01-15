package com.zuehlke.testing.coverage.solution;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.zuehlke.testing.coverage.example.CoverageExampleFromSlide;

class CoverageExampleFromSlideStatementCoverageTest {

	private CoverageExampleFromSlide testee = new CoverageExampleFromSlide();

	@Test
	// Achieves 100% statement coverage
	void testIsShopOpen_vip_open() {
		// act
		boolean result = testee.isShopOpen(LocalTime.of(9, 00), true);

		// assert
		assertThat(result, is(true));
	}
}
