package com.zuehlke.testing.coverage.example;

public class MisleadingCoverage {

	public String coverage100ButNPE(final boolean condition) {
		String value = null;
		if (condition) {
			value = String.valueOf(condition);
		}
		return value.trim();
	}
}