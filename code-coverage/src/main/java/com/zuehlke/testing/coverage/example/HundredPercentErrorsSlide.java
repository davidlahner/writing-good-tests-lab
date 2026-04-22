package com.zuehlke.testing.coverage.example;

/**
 * This class shows typical errors undetected by 100% code coverage with
 * condition coverage.
 */
public class HundredPercentErrorsSlide {

	public int exampleA(int a, int b) {
		return a / b;
	}

	public String exampleB(String value) {
		if (value != "") {
			return value.toLowerCase();
		}
		return value;
	}

	public void exampleC(Bug bug) {
		if (bug.isOk()) {
			bug.statement();
		} else {
			bug.oops();
		}
	}

	public int exampleD(boolean a, boolean b) {
		int value = 0;
		if (a) {
			value++;
		}
		value++;
		if (a) {
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
