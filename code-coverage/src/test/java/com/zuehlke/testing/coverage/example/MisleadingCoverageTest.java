package com.zuehlke.testing.coverage.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
//TODO: remove @Disabled to run test
class MisleadingCoverageTest {

	final MisleadingCoverage coverage = new MisleadingCoverage();

	@Test
	void testCoverage100ButNPE1() {
		coverage.coverage100ButNPE(true);
	}

	@Test
	void testCoverage100ButNPE2() {
		// Triggers a NullPointerException
		coverage.coverage100ButNPE(false);
	}
}
