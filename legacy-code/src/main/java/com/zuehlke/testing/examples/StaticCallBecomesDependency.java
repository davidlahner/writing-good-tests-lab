package com.zuehlke.testing.examples;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class StaticCallBecomesDependency {

	// Context: A voicemail system for multiple users, recording messages on calls
	// to absent users

	public Duration getDurationOfAllMessagesFor(User user) {
		List<Call> calls = Voicemail.getCallsFor(user);
		Duration sum = Duration.ZERO;
		for (Call call : calls) {
			sum = sum.plus(call.getDuration());
		}
		return sum;
	}

	// --- dependencies, out of scope of the example ---

	class User {
	}

	class Call {
		public Duration getDuration() {
			return null;
		}
	}

	static class Voicemail {
		static List<Call> getCallsFor(User user) {
			return Collections.emptyList();
		}
	}

}
