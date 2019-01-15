package com.zuehlke.testing.solutions;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.zuehlke.testing.solutions.StaticCallExtracted.Call;

public class StaticCallExtractedTest {

	private long[] instants;
	private int now = 0;
	private Call testCall = new Call() {
		@Override
		long instantAsMillis() {
			return instants[now++];
		}
	};

	@Test
	public void recordingDuration() {
		// arrange
		instants = new long[] { 9000000000l, 9000015000l };
		// act
		testCall.recordMessage();
		// assert
		assertThat(testCall.getDuration(), equalTo(Duration.ofSeconds(15)));
	}

}
