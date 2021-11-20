package com.zuehlke.testing.examples;

public class AwkwardDependencyMultipleTimes {

	// Context: A voicemail system for multiple users, recording messages on calls
	// to absent users

	public void recordMessage(Call call) {
		if (call.getOrigin().shouldBeTraced()) {
			new Tracer(call); // a Tracer is an awfully complex object!
		}
		// .. actual recording of the message
	}

	// --- dependencies, out of scope of the example ---

	class Call {
		public User getOrigin() {
			return null;
		}
	}

	class User {
		private boolean shouldBeTraced;

		public boolean shouldBeTraced() {
			return shouldBeTraced;
		}
	}

	class Tracer {
		Tracer(Call toBeTraced) {
		}
	}

}
