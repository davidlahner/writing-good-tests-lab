package com.zuehlke.testing.testdoubles.exercise;

public class Telephone {

	private VoiceMailService voiceMailService;
	private boolean busy = false;

	public Telephone(VoiceMailService voiceMailService) {
		super();
		this.voiceMailService = voiceMailService;
	}

	public void call(String callingNumber) {
		if (busy) {
			voiceMailService.call(callingNumber);
		}
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

}
