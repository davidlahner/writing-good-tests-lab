package com.zuehlke.testing.testdoubles.examples;

import java.util.ArrayList;
import java.util.List;

interface MailService {
	public void send(Message msg);
}

public class MailServiceSpy implements MailService {
	private List<Message> messages = new ArrayList<>();

	public void send(Message msg) {
		messages.add(msg);
	}

	public int numberSent() {
		return messages.size();
	}
}

interface Message {
}