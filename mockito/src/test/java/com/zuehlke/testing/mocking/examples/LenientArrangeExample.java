package com.zuehlke.testing.mocking.examples;

import com.zuehlke.testing.mocking.person.Person;
import com.zuehlke.testing.mocking.person.PersonDao;
import com.zuehlke.testing.mocking.person.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

public class LenientArrangeExample {

    private final PersonDao personDao = Mockito.mock(PersonDao.class);
    private final PersonService testee = new PersonService(personDao);

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
