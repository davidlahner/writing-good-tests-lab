package com.zuehlke.testing.mocking.examples;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;

import static org.assertj.core.api.Assertions.assertThat;

public class StubExample {

	private DocumentStore testee = new DocumentStore();

	@Test
	public void addDocument_empty_hasDocument() {
		// arrange
		StoreListener dummyListener = Mockito.mock(StoreListener.class);
		Mockito.when(dummyListener.shouldSumSizes()).thenReturn(true);
		testee.addListener(dummyListener);
		// act
		testee.addDocument("New Document", new byte[0]);
		// assert
		assertThat(testee.isEmpty()).isFalse();
	}
}
