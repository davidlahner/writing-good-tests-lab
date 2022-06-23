package com.zuehlke.testing.mocking.demo;

import com.zuehlke.testing.mocking.document.DocumentStore;
import com.zuehlke.testing.mocking.document.StoreListener;
import com.zuehlke.testing.mocking.person.Person;
import com.zuehlke.testing.mocking.person.PersonDao;
import com.zuehlke.testing.mocking.person.PersonService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Demo {
    private final DocumentStore testee = new DocumentStore();

    @Nested
    class Basics {
        //Create a Stub
        @Test
        public void addDocument_empty_hasDocument() {
            // arrange

            // act
            testee.addDocument("New Document", new byte[0]);
            // assert
            assertThat(testee.isEmpty()).isFalse();
        }


        //Verification
        @Test
        public void addDocument_empty_notifyName() {
            // arrange
            StoreListener mock = Mockito.mock(StoreListener.class);
            testee.addListener(mock);
            // act
            testee.addDocument("New Document", new byte[0]);
            // assert
        }


        //return value
        @Test
        public void addDocument_empty_sumSizes() {
            // arrange
            StoreListener mock = Mockito.mock(StoreListener.class);

            testee.addListener(mock);
            // act
            testee.addDocument("New Document", new byte[0]);
            // assert
            Mockito.verify(mock).bytesAdded(0);
        }
    }

    //Strict verification
    @Test
    public void addDocument_withContent() {
        // arrange
        StoreListener mock = Mockito.mock(StoreListener.class);
        testee.addListener(mock);
        // act
        testee.addDocument("Another Document", new byte[]{1, 2, 3, 4, 5});
        // assert
    }


    @Nested
    class ArgumentCaptors {
        @Test
        public void addDocument_withContent_withCaptor() {
            // arrange
            StoreListener listener = Mockito.mock(StoreListener.class);
            testee.addListener(listener);
            // act
            testee.addDocument("Another Document", new byte[]{1, 2, 3, 4, 5});
            // assert

        }


        @Test
        public void addDocument_withContent_withoutCaptor() {
            // arrange
            StoreListener listener = Mockito.mock(StoreListener.class);
            testee.addListener(listener);
            // act
            testee.addDocument("Another Document", new byte[]{1, 2, 3, 4, 5});
            // assert

        }
    }

    @Nested
    class CallTimes {
        @Test
        public void addDocument_withContent() {
            // arrange
            StoreListener mock = Mockito.mock(StoreListener.class);
            Mockito.when(mock.shouldSumSizes()).thenReturn(false, true);
            testee.addListener(mock);
            // act
            testee.addDocument("First Document", new byte[]{1, 2});
            testee.addDocument("Second Document", new byte[]{1, 2, 3});
            testee.addDocument("Third Document", new byte[]{1, 2, 3, 4});
            // assert

        }
    }

    @Nested
    class Exceptions {
        @Test
        void addDocument_withContent_throwException() {
            // arrange
            StoreListener mock = Mockito.mock(StoreListener.class);
            testee.addListener(mock);

            // act
            assertThrows(IllegalArgumentException.class, () ->
                    testee.addDocument("Another Document", new byte[]{1, 2, 3, 4, 5}));
        }

        @Test
        void addDocument_withContent_throwExceptionFromVoid() {
            // arrange
            StoreListener mock = Mockito.mock(StoreListener.class);
            testee.addListener(mock);

            // act
            assertThrows(IllegalArgumentException.class, () ->
                    testee.addDocument("Another Document", new byte[]{1, 2, 3, 4, 5}));
        }
    }

    @Nested
    class ArrangeAssert {
        private final PersonDao personDao = Mockito.mock(PersonDao.class);
        private final PersonService testee = new PersonService(personDao);

        @Test
        public void addDocument_withContent_anyName() {
            // arrange
            Person peterParker = new Person(1, "Peter", "Parker", 21);

            // act
            Person result = testee.findById(1);
            // assert
            assertThat(result).isEqualTo(peterParker);

        }
    }

}
