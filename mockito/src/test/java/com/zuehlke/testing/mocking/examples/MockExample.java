package com.zuehlke.testing.mocking.examples;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;

public class MockExample {

	private DocumentStore testee = new DocumentStore();

	@Test
	public void addDocument_empty_notifyName() {
		// arrange
		StoreListener mock = Mockito.mock(StoreListener.class);
		testee.addListener(mock);
		// act
		testee.addDocument("New Document", new byte[0]);
		// assert
		Mockito.verify(mock).documentAdded("New Document");
	}

	@Test
	public void addDocument_empty_sumSizes() {
		// arrange
		StoreListener mock = Mockito.mock(StoreListener.class);
		Mockito.when(mock.shouldSumSizes()).thenReturn(true);
		testee.addListener(mock);
		// act
		testee.addDocument("New Document", new byte[0]);
		// assert
		Mockito.verify(mock).bytesAdded(0);
	}
}
