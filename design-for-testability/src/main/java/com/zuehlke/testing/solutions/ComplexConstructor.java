package com.zuehlke.testing.solutions;

import java.util.Collections;
import java.util.List;

public class ComplexConstructor {

	// Context: A voicemail system for multiple users, recording messages on calls
	// to absent users

	private List<Call> calls;

	@Deprecated
	public ComplexConstructor(int userId) {
		this(Voicemail.getCallsFor(userId));
	}

	public ComplexConstructor(List<Call> calls) {
		this.calls = calls;
		// ...
	}

	// business logic to test ...

	// --- dependencies, out of scope of the example ---

	class User {
	}

	class Call {
	}

	static class UserRepository {
		static User getUser(int userId) {
			return null;
		}
	}

	static class Voicemail {
		static List<Call> getCallsFor(User user) {
			return Collections.emptyList();
		}

		static List<Call> getCallsFor(int userId) {
			User user = UserRepository.getUser(userId);
			return getCallsFor(user);
		}
	}

}
