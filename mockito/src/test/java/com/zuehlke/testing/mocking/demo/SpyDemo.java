package com.zuehlke.testing.mocking.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SpyDemo {

    @Test
    public void whenSpyingOnList_thenCorrect() {
    }

    @Test
    public void whenStubASpy_thenStubbed() {
        List<String> list = new ArrayList<String>();
        List<String> spyList = Mockito.spy(list);

        assertThat(spyList).isEmpty();

        assertThat(spyList).hasSize(100);
    }
}
