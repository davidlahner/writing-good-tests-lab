package com.zuehlke.testing.examples;

import java.util.Collections;
import java.util.List;

public class ComplexConstructor {

	// Context: A voicemail system for multiple users, recording messages on calls
	// to absent users

	private List<Call> calls;

	public ComplexConstructor(int userId) {
		User user = UserRepository.getUser(userId);
		calls = Voicemail.getCallsFor(user);
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
	}

}
