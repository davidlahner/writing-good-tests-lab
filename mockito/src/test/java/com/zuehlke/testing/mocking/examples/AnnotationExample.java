package com.zuehlke.testing.mocking.examples;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;

public class AnnotationExample {

	private DocumentStore testee = new DocumentStore();

	@Mock
	private StoreListener listener;
	@Captor
	private ArgumentCaptor<String> arg;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addDocument_withContent() {
		// arrange
		testee.addListener(listener);
		// act
		testee.addDocument("Another Document", new byte[] { 1, 2, 3, 4, 5 });
		// assert
		Mockito.verify(listener).documentAdded(arg.capture());
		assertThat(arg.getValue(), startsWith("Another"));
	}
}
