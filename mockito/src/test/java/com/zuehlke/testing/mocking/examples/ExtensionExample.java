package com.zuehlke.testing.mocking.examples;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;

@ExtendWith(MockitoExtension.class)
public class ExtensionExample {

	private DocumentStore testee = new DocumentStore();

	@Test
	public void addDocument_withContent(@Mock StoreListener listener) {
		// arrange
		testee.addListener(listener);
		// act
		testee.addDocument("Another Document", new byte[] { 1, 2, 3, 4, 5 });
		// assert
		ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
		Mockito.verify(listener).documentAdded(arg.capture());
		assertThat(arg.getValue(), startsWith("Another"));
	}
}
