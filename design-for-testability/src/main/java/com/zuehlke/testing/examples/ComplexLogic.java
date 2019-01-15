package com.zuehlke.testing.examples;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ComplexLogic {

	// Context: A voicemail system for multiple users, 
	// recording messages on calls to absent users

	List<Call> calls;

	/**
	 * Business logic to test. - only selective calls - 
	 * each caller only once, but order should remain
	 */
	public List<User> getPeopleThatLeftAMessage() {
		Set<User> callers = new LinkedHashSet<User>();
		for (Call call : calls) {
			if (call.getOrigin() != null //
					&& call.getOrigin() != User.ANONYMOUS //
					&& call.getDuration() != null //
					&& !call.getDuration().isZero()) {
				callers.add(call.getOrigin());
			}
		}
		return new ArrayList<User>(callers);
	}

	// --- dependencies, out of scope of the example ---

	static class User {
		static User ANONYMOUS = new User();
	}

	class Call {
		public User getOrigin() {
			return null;
		}

		public Duration getDuration() {
			return null;
		}
	}
}
