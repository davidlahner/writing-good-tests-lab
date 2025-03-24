package com.zuehlke.testing.mocking.examples;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

class ThrowExceptionExample {

	private DocumentStore testee = new DocumentStore();

	@Test
	void addDocument_withContent_throwException() {
		// arrange
		StoreListener mock = Mockito.mock(StoreListener.class);
		testee.addListener(mock);
		Mockito.when(mock.shouldSumSizes())//
				.thenThrow(new IllegalArgumentException("Test"));
		// act
		assertThrows(IllegalArgumentException.class, () ->
				testee.addDocument("Another Document", new byte[] { 1, 2, 3, 4, 5 }));
	}

	@Test
	void addDocument_withContent_throwExceptionFromVoid() {
		// arrange
		StoreListener mock = Mockito.mock(StoreListener.class);
		testee.addListener(mock);
		Mockito.doThrow(new IllegalArgumentException("Test"))//
				.when(mock).documentAdded(anyString());
		// act
		assertThrows(IllegalArgumentException.class, () ->
				testee.addDocument("Another Document", new byte[] { 1, 2, 3, 4, 5 }));
	}
}

