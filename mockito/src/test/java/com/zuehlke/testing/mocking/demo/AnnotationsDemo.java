package com.zuehlke.testing.mocking.demo;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class AnnotationsDemo {
    private final DocumentStore testee = new DocumentStore();

    private StoreListener listener;
    private ArgumentCaptor<String> arg;

    @Test
    public void addDocument_withContent() {
        // arrange
        testee.addListener(listener);
        // act
        testee.addDocument("Another Document", new byte[]{1, 2, 3, 4, 5});
        // assert
        Mockito.verify(listener).documentAdded(arg.capture());
        assertThat(arg.getValue()).startsWith("Another");
    }
}
