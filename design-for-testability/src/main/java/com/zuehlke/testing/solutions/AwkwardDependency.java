package com.zuehlke.testing.solutions;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class AwkwardDependency {

    // Context: A voicemail system for multiple users, recording messages on calls
    // to absent users

    private final UserRepository repository;
    private final Voicemail voicemail;

    public AwkwardDependency(UserRepository repository, Voicemail voicemail) {
        this.repository = repository;
        this.voicemail = voicemail;
    }

    @Deprecated
    public AwkwardDependency() {
        this.repository = new UserRepository();
        this.voicemail = new Voicemail();
    }

    public Duration getDurationOfAllMessagesFor(int userId) {
        User user = repository.getUser(userId);
        List<Call> calls = voicemail.getCallsFor(user);
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
