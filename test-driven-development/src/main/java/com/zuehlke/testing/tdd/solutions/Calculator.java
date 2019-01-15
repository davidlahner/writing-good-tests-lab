package com.zuehlke.testing.tdd.solutions;

import java.util.Arrays;

public class Calculator {

	public int calculate(String string) {
		if (string.isEmpty()) {
			return 0;
		}
		String[] values = string.split(",");
		if (values.length > 3) {
			throw new IllegalArgumentException("too many arguments");
		}
		return Arrays.stream(values).mapToInt(Integer::valueOf).sum();
	}

}
