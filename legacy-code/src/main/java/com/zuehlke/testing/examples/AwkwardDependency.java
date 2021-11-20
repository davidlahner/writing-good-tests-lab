package com.zuehlke.testing.examples;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class AwkwardDependency {

    // Context: A voicemail system for multiple users, recording messages on calls
    // to absent users

    public Duration getDurationOfAllMessagesFor(int userId) {
        User user = new UserRepository().getUser(userId); // a user repository is an awfully complex object!
        List<Call> calls = new Voicemail().getCallsFor(user); // a voicemail is an awfully complex object!
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

    static class UserRepository {
        User getUser(int userId) {
            return null;
        }
    }

    static class Voicemail {
        List<Call> getCallsFor(User user) {
            return Collections.emptyList();
        }
    }

}
