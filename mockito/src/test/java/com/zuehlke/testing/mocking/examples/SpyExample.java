package com.zuehlke.testing.mocking.examples;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpyExample {

	@Test
	public void whenSpyingOnList_thenCorrect() {
		List<String> list = new ArrayList<String>();
		List<String> spyList = Mockito.spy(list);

		spyList.add("one");
		spyList.add("two");

		Mockito.verify(spyList).add("one");
		Mockito.verify(spyList).add("two");

		assertThat(spyList, hasSize(2));
	}

	@Test
	public void whenStubASpy_thenStubbed() {
		List<String> list = new ArrayList<String>();
		List<String> spyList = Mockito.spy(list);

		assertThat(spyList, hasSize(0));

		Mockito.when(spyList.size()).thenReturn(100);
		assertThat(spyList, hasSize(100));
	}
}
