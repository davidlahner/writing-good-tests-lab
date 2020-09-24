package com.zuehlke.testing.mocking.solutions;

import com.zuehlke.testing.mocking.person.Person;
import com.zuehlke.testing.mocking.person.PersonDao;
import com.zuehlke.testing.mocking.person.PersonService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.AdditionalMatchers.lt;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    @Mock
    private PersonDao mock;
    private PersonService testee;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
        testee = new PersonService(mock);
    }

    // Exercise RETURN-VALUE
    @Test
    void findById_existingId_personReturned() {
        // arrange
        Person person = new Person(1, "Peter", "Meier", 21);
        when(mock.findById(1)).thenReturn(person);

        // act
        Person result = testee.findById(1);

        // assert
        assertThat(result, is(equalTo(person)));
        verify(mock).findById(1);
    }

    // Exercise RETURN-VALUE
    @Test
    void findById_queriedIdNotMocked_nullReturned() {
        // arrange
        Person person = new Person(1, "Peter", "Meier", 21);
        when(mock.findById(1)).thenReturn(person);

        // act
        Person result = testee.findById(2);

        // assert
        assertThat(result, is(nullValue()));
        verify(mock).findById(2);
    }

    // Exercise EXCEPTION (easy)
    @Test
    void findById_negativeId_IllegalArgumentExceptionThrown() {
        // arrange
        when(mock.findById(lt(0))).thenThrow(new IllegalArgumentException());

        // act
        assertThrows(IllegalArgumentException.class, () -> testee.findById(-1));
    }

    // Exercise EXCEPTION (sophisticated)
    @Test
    void findById_negativeIdDynamic_IllegalArgumentExceptionThrown() {
        // arrange
        when(mock.findById(anyInt())).then(invocation -> {
            if ((Integer) invocation.getArgument(0) < 0) {
                throw new IllegalArgumentException();
            }
            return null;
        });

        // act
        assertThrows(IllegalArgumentException.class, () -> testee.findById(-1));
        assertThat(testee.findById(1), is(nullValue()));
    }

    // Exercise METHOD-CALLED
    @Test
    void findAll_listOfPersonsReturned() {
        // arrange
        Person person1 = new Person(1, "Peter", "Meier", 21);
        Person person2 = new Person(2, "Gabi", "Müller", 35);
        List<Person> answer = new ArrayList<>();
        answer.add(person1);
        answer.add(person2);
        when(mock.findAll()).thenReturn(answer);

        // act
        List<Person> result = testee.findAll();

        // assert
        assertThat(result, Matchers.contains(person1, person2));
        verify(mock).findAll();
    }

    // Exercise CALL-COUNT
    @Test
    void findById_multipleCalls_callCountVerfied() {
        // Act
        testee.findById(11);
        testee.findAll();
        testee.findById(1);
        testee.findById(2);

        // assert
        verify(mock, times(3)).findById(anyInt());
        verify(mock).findById(1);
        verify(mock).findAll();
    }
}
