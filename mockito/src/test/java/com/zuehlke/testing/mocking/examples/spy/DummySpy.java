package com.zuehlke.testing.mocking.examples.spy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class DummySpy {

	@Test
	public void test_dummyReturnsMock_UnexpectedBehavior() {
		// Arrange
		Model model = Mockito.mock(Model.class);
		Mockito.when(model.getSubModel()).thenReturn(dummySubModel());

		// Act
		String name = model.getSubModel().getName();

		// assert
		assertThat(name).isNotNull();
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
