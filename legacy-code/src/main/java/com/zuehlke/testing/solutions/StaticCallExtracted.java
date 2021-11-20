package com.zuehlke.testing.solutions;

import java.time.Duration;

public class StaticCallExtracted {

	// Context: A voicemail system for multiple users, recording messages on calls
	// to absent users

	static class Call {

		private Duration duration;

		public Duration getDuration() {
			return duration;
		}

		public void recordMessage() {
			long startRecording = instantAsMillis();
			// .. actual recording of the message
			long millis = instantAsMillis() - startRecording;
			this.duration = Duration.ofMillis(millis);
		}

		long instantAsMillis() {
			return System.currentTimeMillis();
		}

	}
	// see StaticCallExtractedTest
}
