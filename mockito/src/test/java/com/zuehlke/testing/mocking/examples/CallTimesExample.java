package com.zuehlke.testing.mocking.examples;

import static org.mockito.ArgumentMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;

public class CallTimesExample {

	private DocumentStore testee = new DocumentStore();

	@Test
	public void addDocument_withContent() {
		// arrange
		StoreListener mock = Mockito.mock(StoreListener.class);
		Mockito.when(mock.shouldSumSizes()).thenReturn(false, true);
		testee.addListener(mock);
		// act
		testee.addDocument("First Document", new byte[] { 1, 2 });
		testee.addDocument("Second Document", new byte[] { 1, 2, 3 });
		testee.addDocument("Third Document", new byte[] { 1, 2, 3, 4 });
		// assert
		Mockito.verify(mock, Mockito.times(3)).documentAdded(//
				matches("(First|Second|Third) Document"));
		Mockito.verify(mock, Mockito.atLeast(1)).shouldSumSizes();
		Mockito.verify(mock, Mockito.atMost(2)).bytesAdded(Mockito.anyInt());
		Mockito.verifyNoMoreInteractions(mock);
	}
}
