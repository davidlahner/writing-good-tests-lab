package com.zuehlke.testing.mocking.examples;

import com.zuehlke.testing.mocking.person.Person;
import com.zuehlke.testing.mocking.person.PersonDao;
import com.zuehlke.testing.mocking.person.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AnnotationConstructorExample {

    private PersonService testee;

    @Mock
    private PersonDao personDao;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        testee = new PersonService(personDao);
    }

    @Test
    public void addDocument_withContent() {
        List<Person> actual = testee.findAll();

        assertThat(actual).isEmpty();
    }
}
