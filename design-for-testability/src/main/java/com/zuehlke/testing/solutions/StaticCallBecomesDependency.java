package com.zuehlke.testing.solutions;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class StaticCallBecomesDependency {

	// Context: A voicemail system for multiple users, recording messages on calls
	// to absent users

	private final Voicemail voicemail;

	public StaticCallBecomesDependency(Voicemail voicemail) {
		this.voicemail = voicemail;
	}

	@Deprecated
	public StaticCallBecomesDependency() {
		this.voicemail = Voicemail.instance();
	}

	// Alternative 1: Voicemail is dependency of this class
	public Duration getDurationOfAllMessagesFor(User user) {
		List<Call> calls = voicemail.getCallsFor(user);
		Duration sum = Duration.ZERO;
		for (Call call : calls) {
			sum = sum.plus(call.getDuration());
		}
		return sum;
	}

	// Alternative 2: No dependency on voicemail and user, calls are collected by
	// the caller
	public Duration getDurationOfAllMessages(List<Call> calls) {
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
		static Voicemail instance() {
			return null;
		}

		List<Call> getCallsFor(User user) {
			return Collections.emptyList();
		}
	}

}
