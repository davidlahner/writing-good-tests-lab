package com.zuehlke.testing.coverage.example;

import org.junit.jupiter.api.Test;

class CoverageTest {

	private Coverage testee = new Coverage();

	@Test
	void testDoIfShort() {
		// act
		testee.doIfShort(true);
	}

	@Test
	void testDoCondition() {
		// act
		testee.doCondition(true, false);
	}

	@Test
	void testDoPath_conditionTrue() {
		// act
		testee.doPath(true);
	}

	@Test
	void testDoPath_conditionFalse() {
		// act
		testee.doPath(false);
	}
}
