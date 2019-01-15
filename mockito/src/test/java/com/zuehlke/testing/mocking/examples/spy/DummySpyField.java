package com.zuehlke.testing.mocking.examples.spy;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class DummySpyField {
	@Spy
	private SubModel sub = new DummySubModel();

	@BeforeEach
	public void initSpy() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_dummyReturnsMock_UnexpectedBehavior() {
		// Arrange
		Model model = Mockito.mock(Model.class);
		Mockito.when(model.getSubModel()).thenReturn(sub);

		// Act
		String name = model.getSubModel().getName();

		// assert
		assertThat(name, is(notNullValue()));
		verify(sub).getName();
	}

	static class DummySubModel implements SubModel {
		@Override
		public String getName() {
			return "anything but null";
		}
		// other dummy states...
	}
}
