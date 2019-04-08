package com.zuehlke.testing.hamcrest.solutions;

import com.zuehlke.testing.hamcrest.Person;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class PersonTest {

    @Test
    void constructor_parametersGiven_initializedPerson() {
        // act
        Person result = new Person(1, "Peter", "Maler", 42);

        // assert
        assertThat(result, is(notNullValue()));
        assertThat("id", result.getId(), is(equalTo(1)));
        assertThat("first name", result.getFirstname(), is(equalTo("Peter")));
        assertThat("last name", result.getLastname(), is(equalTo("Maler")));
        assertThat("age", result.getAge(), is(equalTo(42)));
    }
}
