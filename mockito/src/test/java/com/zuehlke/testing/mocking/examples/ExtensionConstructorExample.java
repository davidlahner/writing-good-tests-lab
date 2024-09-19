package com.zuehlke.testing.mocking.examples;

import com.zuehlke.testing.mocking.person.Person;
import com.zuehlke.testing.mocking.person.PersonDao;
import com.zuehlke.testing.mocking.person.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ExtensionConstructorExample {

    @InjectMocks
    private PersonService testee;

    @Mock
    private PersonDao personDao;

    @Test
    public void addDocument_withContent() {
        List<Person> actual = testee.findAll();

        assertThat(actual).isEmpty();
    }
}
