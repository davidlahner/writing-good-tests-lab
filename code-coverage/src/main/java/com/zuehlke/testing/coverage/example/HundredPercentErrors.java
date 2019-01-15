package com.zuehlke.testing.coverage.example;

/**
 * This class shows typical errors undetected by 100% code coverage with
 * condition coverage.
 */
public class HundredPercentErrors {

	/**
	 * 100% code coverage may not detect division by zero condition!
	 */
	public int divByZero(int a, int b) {
		return a / b;
	}

	/**
	 * 100% code coverage may not detect unhandled null pointer condition!
	 */
	public String missingNull(String value) {
		if (value != "") {
			return value.toLowerCase();
		}
		return value;
	}

	/**
	 * 100% code coverage may not detect unhandled null pointer condition!
	 */
	public void missingNull2(Bug bug) {
		if (bug.isOk()) {
			bug.statement();
		} else {
			bug.oops();
		}
	}

	// public void relationError(int a, int b){
	//
	//
	// }

	public int[] buildSums(int[] source) {
		int[] dest = new int[source.length];
		dest[0] = source[0];
		for (int i = 1; i < source.length; i++) {
			dest[i] = source[i] + source[i - 1];
		}
		return dest;
	}

	/**
	 * 100% code coverage may not detect the assumed logic error of not using
	 * boolean b!
	 */
	public int doCalc(boolean a, boolean b) {
		int value = 0;
		if (a) {
			value++;
		}
		value++;
		if (a) { // supposed to be b instead of a
			value++;
		} else {
			value--;
		}
		return value;
	}

	private static class Bug {
		boolean isOk() {
			return true;
		}

		void statement() {
		}

		void oops() {
		};
	}

}
