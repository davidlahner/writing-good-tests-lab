package com.zuehlke.testing.mocking.examples.spy;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DummySpy {

	@Test
	public void test_dummyReturnsMock_UnexpectedBehavior() {
		// Arrange
		Model model = Mockito.mock(Model.class);
		Mockito.when(model.getSubModel()).thenReturn(dummySubModel());

		// Act
		String name = model.getSubModel().getName();

		// assert
		assertThat(name, is(notNullValue()));
	}

	private SubModel dummySubModel() {
		return Mockito.spy(DummySubModel.class);
	}

	static abstract class DummySubModel implements SubModel {
		@Override
		public String getName() {
			return "anything but null";
		}
		// other dummy states...
	}
}
