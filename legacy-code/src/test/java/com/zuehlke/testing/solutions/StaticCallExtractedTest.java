package com.zuehlke.testing.solutions;

import com.zuehlke.testing.solutions.StaticCallExtracted.Call;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class StaticCallExtractedTest {

    private long[] instants;
    private int now = 0;
    private Call testCall = new Call() {
        @Override
        long instantAsMillis() {
            return instants[now++];
        }
    };

    @Test
    void recordingDuration() {
        // arrange
        instants = new long[]{9000000000L, 9000015000L};
        // act
        testCall.recordMessage();
        // assert
        assertThat(testCall.getDuration(), equalTo(Duration.ofSeconds(15)));
    }

}
