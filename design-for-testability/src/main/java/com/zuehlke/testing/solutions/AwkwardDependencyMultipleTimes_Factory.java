package com.zuehlke.testing.solutions;

public class AwkwardDependencyMultipleTimes_Factory {

	// Context: A voicemail system for multiple users, recording messages on calls
	// to absent users

	private final TracerFactory tracerFactory;

	// Alternative 2: Factory dependency
	public AwkwardDependencyMultipleTimes_Factory(TracerFactory tracerFactory) {
		this.tracerFactory = tracerFactory;
	}

	@Deprecated
	public AwkwardDependencyMultipleTimes_Factory() {
		this.tracerFactory = new TracerFactory();
	}

	public void recordMessage(Call call) {
		if (call.getOrigin().shouldBeTraced()) {
			tracerFactory.createFor(call); // a Tracer is an awfully complex object!
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

	class TracerFactory {
		Tracer createFor(Call call) {
			return new Tracer(call);
		}
	}

	class Tracer {
		Tracer(Call toBeTraced) {
		}
	}

}
