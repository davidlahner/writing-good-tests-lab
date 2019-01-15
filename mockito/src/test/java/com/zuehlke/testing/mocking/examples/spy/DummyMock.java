package com.zuehlke.testing.mocking.examples.spy;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@Disabled
//TODO: remove @Disabled to run test
public class DummyMock {

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
		SubModel sub = Mockito.mock(SubModel.class);
		Mockito.when(sub.getName()).thenReturn("anything but null");
		// other dummy states...
		return sub;
	}
}
