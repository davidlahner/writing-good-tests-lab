package com.zuehlke.testing.rules.solutions;

import com.zuehlke.testing.rules.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(LogTestExecutionExtension.class)
class PersonTest {

    @Test
    void constructor_parametersGiven_initializedPerson() {
        // act
        Person result = new Person("Peter");

        // assert
        assertThat(result).isNotNull();
        assertThat(result.getName()).as("name").isEqualTo("Peter");
    }

    @Test
    void constructor_parameterEmptyString_initializedPerson() {
        // act
        Person result = new Person("");

        // assert
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEmpty();
    }

    @Test
    void constructor_parameterNull_exceptionThrown() {
        // act & assert
        assertThrows(IllegalArgumentException.class, () -> new Person(null));
    }

}
