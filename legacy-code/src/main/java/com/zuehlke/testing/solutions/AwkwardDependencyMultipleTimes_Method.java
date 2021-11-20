package com.zuehlke.testing.solutions;

public class AwkwardDependencyMultipleTimes_Method {

	// Context: A voicemail system for multiple users, recording messages on calls
	// to absent users

	public void recordMessage(Call call) {
		if (call.getOrigin().shouldBeTraced()) {
			createTracerFor(call); // a Tracer is an awfully complex object!
		}
		// .. actual recording of the message
	}

	// Alternative 1: Factory method, can be overridden
	Tracer createTracerFor(Call call) {
		return new Tracer(call);
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
