package com.zuehlke.testing.testdoubles.solution;


import com.zuehlke.testing.testdoubles.exercise.Telephone;
import com.zuehlke.testing.testdoubles.exercise.VoiceMailService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TelephoneTest {

	private static final String NUMBER = "0791234567";

	@Test
	public void testCall_busy_forwardToVoiceMail() {
		// arrange
		VoiceMailServiceSpy spy = new VoiceMailServiceSpy();
		Telephone testee = new Telephone(spy);
		testee.setBusy(true);

		// act
		testee.call(NUMBER);

		// assert
		assertThat(spy.callingNumber).isEqualTo(NUMBER);

	}
}

class VoiceMailServiceSpy implements VoiceMailService {

	String callingNumber;

	@Override
	public void call(String callingNumber) {
		this.callingNumber = callingNumber;
	}

}
