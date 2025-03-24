package com.zuehlke.testing.mocking.examples;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StrictVerificationExample {

	private DocumentStore testee = new DocumentStore();

	@Test
	public void addDocument_withContent() {
		// arrange
		StoreListener mock = Mockito.mock(StoreListener.class);
		testee.addListener(mock);
		// act
		testee.addDocument("Another Document", new byte[] { 1, 2, 3, 4, 5 });
		// assert
		Mockito.verify(mock).documentAdded("Another Document");
		Mockito.verify(mock).shouldSumSizes();
		Mockito.verifyNoMoreInteractions(mock);
	}
}
