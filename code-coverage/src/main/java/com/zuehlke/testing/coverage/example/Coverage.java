package com.zuehlke.testing.coverage.example;

public class Coverage {

	public void doIfShort(boolean condition) {
		if (condition) {
			statement1();
		}
		statement2();
	}

	public void doCondition(boolean a, boolean b) {
		if (a || b) {
			statement1();
		}
		statement2();
	}

	public void doPath(boolean condition) {
		if (condition) {
			statement1();
		}
		statement2();
		if (!condition) {
			statement3();
		}
	}

	private void statement1() {
		// do relevant work
	}

	private void statement2() {
		// do relevant work
	}

	private void statement3() {
		// do relevant work
	}
}
