package com.zuehlke.testing.mocking.examples;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

public class AnnotationExample {

    private final DocumentStore testee = new DocumentStore();

    @Mock
    private StoreListener listener;
    @Captor
    private ArgumentCaptor<String> arg;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addDocument_withContent() {
        // arrange
        testee.addListener(listener);
        // act
        testee.addDocument("Another Document", new byte[]{1, 2, 3, 4, 5});
        // assert
        Mockito.verify(listener).documentAdded(arg.capture());
        assertThat(arg.getValue(), startsWith("Another"));
    }
}
