package com.zuehlke.testing.rules.examples;

import com.zuehlke.testing.rules.Person;
import com.zuehlke.testing.rules.PersonDao;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntegrationTestExample {

    private PersonDao dao = new PersonDao();

    @Test
    void find_oldStyle() {
        // arrange
        Person expected = new Person("Dummy");
        dao.save(expected);
        try {
            // act
            Person person = dao.find(expected.getName());
            // assert
            assertThat(person.getName()).isEqualTo(expected.getName());
        } finally {
            // cleanup
            dao.delete(expected);
        }
    }
}
