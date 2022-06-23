package com.zuehlke.testing.mocking.demo;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;
import com.zuehlke.testing.mocking.person.Person;
import com.zuehlke.testing.mocking.person.PersonDao;
import com.zuehlke.testing.mocking.person.PersonService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

public class ExtensionDemo {

    @Nested
    class ParameterInjection {
        private final DocumentStore testee = new DocumentStore();

        @Test
        public void addDocument_withContent(StoreListener listener) {
            // arrange
            testee.addListener(listener);
            // act
            testee.addDocument("Another Document", new byte[]{1, 2, 3, 4, 5});
            // assert
            ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
            Mockito.verify(listener).documentAdded(arg.capture());
            assertThat(arg.getValue()).startsWith("Another");
        }
    }

    @Nested
    class FieldInjection {
        private PersonDao personDao;
        private PersonService testee;

        @Test
        public void addDocument_withContent_anyName() {
            // arrange
            Person peterParker = new Person(1, "Peter", "Parker", 21);
            Mockito.when(personDao.findById(anyInt())).thenReturn(peterParker);
            // act
            Person result = testee.findById(1);
            // assert
            assertThat(result).isEqualTo(peterParker);
            Mockito.verify(personDao).findById(1);
        }
    }
}
