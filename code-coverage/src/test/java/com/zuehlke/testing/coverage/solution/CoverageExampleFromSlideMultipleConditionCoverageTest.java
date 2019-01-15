package com.zuehlke.testing.coverage.solution;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.zuehlke.testing.coverage.example.CoverageExampleFromSlide;

class CoverageExampleFromSlideMultipleConditionCoverageTest {

	private CoverageExampleFromSlide testee = new CoverageExampleFromSlide();

	@Test
	void testIsShopOpen_vip_open() {
		// act
		boolean result = testee.isShopOpen(LocalTime.of(9, 00), true);

		// assert
		assertThat(result, is(true));
	}

	@Test
	void testIsShopOpen_8am_notOpen() {
		// act
		boolean result = testee.isShopOpen(LocalTime.of(8, 00), false);

		// assert
		assertThat(result, is(false));
	}

}
