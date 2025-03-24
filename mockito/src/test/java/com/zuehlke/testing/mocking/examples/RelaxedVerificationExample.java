package com.zuehlke.testing.mocking.examples;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;

public class RelaxedVerificationExample {

	private DocumentStore testee = new DocumentStore();

	@Test
	public void addDocument_withContent_anyName() {
		// arrange
		StoreListener mock = Mockito.mock(StoreListener.class);
		testee.addListener(mock);
		// act
		testee.addDocument("Another Document", new byte[] { 1, 2, 3, 4, 5 });
		// assert
		Mockito.verify(mock).documentAdded(anyString());
	}
}
