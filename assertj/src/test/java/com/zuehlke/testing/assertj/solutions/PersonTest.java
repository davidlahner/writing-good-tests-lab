package com.zuehlke.testing.assertj.solutions;

import com.zuehlke.testing.assertj.example.domain.people.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void constructor_parametersGiven_initializedPerson() {
        // act
        Person result = new Person("Peter", "Maler", 42);

        // assert
        assertThat(result).isNotNull();
        assertThat(result.getFirstName()).as("first name").isEqualTo("Peter");
        assertThat(result.getLastName()).as("last name").isEqualTo("Maler");
        assertThat(result.getAge()).as("age").isEqualTo(42);
    }
}
