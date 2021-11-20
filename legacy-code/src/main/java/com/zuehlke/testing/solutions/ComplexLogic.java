package com.zuehlke.testing.solutions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ComplexLogic {

	// Context: A voicemail system for multiple users, recording messages on calls
	// to absent users

	List<Call> calls;

	/** business logic to test. */
	public List<User> getPeopleThatLeftAMessage() {
		Set<User> callers = new LinkedHashSet<User>();
		for (Call call : calls) {
			if (call.isIdentifiedCallWithMessage()) {
				callers.add(call.getOrigin());
			}
		}
		return new ArrayList<User>(callers);
	}

	// --- dependencies, out of scope of the example ---

	class User {
		User ANONYMOUS = new User();

		boolean isAnonymous() {
			return this.equals(ANONYMOUS);
		}
	}

	class Call {
		private User origin;
		private Duration duration;

		public User getOrigin() {
			return origin;
		}

		public Duration getDuration() {
			return duration;
		}

		boolean isIdentifiedCallWithMessage() {
			return isIdentified() && hasMessage();
		}

		boolean isIdentified() {
			return origin != null && !origin.isAnonymous();
		}

		boolean hasMessage() {
			return duration != null && !duration.isZero();
		}
	}
}
