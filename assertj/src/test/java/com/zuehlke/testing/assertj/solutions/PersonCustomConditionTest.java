package com.zuehlke.testing.assertj.solutions;

import com.zuehlke.testing.assertj.example.domain.people.Person;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("SameParameterValue")
class PersonCustomConditionTest {

    @Test
    void constructor_parametersGiven_initializedPerson() {
        // act
        Person result = new Person("Peter", "Maler", 42);

        // assert
        assertThat(result)
                .is(havingFirstName("Peter"))
                .is(havingLastName("Maler"));
    }

    private Condition<Person> havingFirstName(String expected) {
        return new Condition<>(person -> person.getFirstName().equals(expected), "First name should be <%s>", expected);
    }

    private Condition<Person> havingLastName(String expected) {
        return new Condition<>(person -> person.getLastName().equals(expected), "Last name should be <%s>", expected);
    }

}
