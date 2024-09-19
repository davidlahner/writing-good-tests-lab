package com.zuehlke.testing.mocking.examples;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgumentCaptorExample {

	private DocumentStore testee = new DocumentStore();

	@Test
	public void addDocument_withContent() {
		// arrange
		StoreListener listener = Mockito.mock(StoreListener.class);
		testee.addListener(listener);
		// act
		testee.addDocument("Another Document", new byte[] { 1, 2, 3, 4, 5 });
		// assert
		ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
		Mockito.verify(listener).documentAdded(arg.capture());
		assertThat(arg.getValue()).startsWith("Another");
	}
}
