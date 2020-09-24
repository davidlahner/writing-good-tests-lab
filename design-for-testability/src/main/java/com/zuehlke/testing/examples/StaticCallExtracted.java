package com.zuehlke.testing.examples;

import java.time.Duration;

public class StaticCallExtracted {

    // Context: A voicemail system for multiple users, recording messages on calls
    // to absent users

    class Call {

        private Duration duration;

        public Duration getDuration() {
            return duration;
        }

        public void recordMessage() {
            long startRecording = System.currentTimeMillis();
            // .. actual recording of the message
            long millis = System.currentTimeMillis() - startRecording;
            this.duration = Duration.ofMillis(millis);
        }

    }

}
