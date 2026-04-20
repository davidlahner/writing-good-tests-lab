package com.zuehlke.testing.mocking.examples;

import com.zuehlke.testing.mocking.document.DocumentStore;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

public class MockStaticMethodExample {

	@Test
	public void getVersion_mocked_returns() {
		assertThat(DocumentStore.getVersion()).isEqualTo("v5");

		try(MockedStatic<DocumentStore> mocked = mockStatic(DocumentStore.class)) {
			mocked.when(DocumentStore::getVersion).thenReturn("vMocked");
			assertThat(DocumentStore.getVersion()).isEqualTo("vMocked");
			mocked.verify(DocumentStore::getVersion);
		}
		assertThat(DocumentStore.getVersion()).isEqualTo("v5");
	}


}
