package com.zuehlke.testing.assertj.solutions;

import com.zuehlke.testing.assertj.example.domain.people.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;


class CollectionTest {

    @Test
    void contains_primitives() {
        // arrange
        List<Integer> values = Arrays.asList(1, 3, 4, 2, 5);

        // assert
        // 1. assert 3 is present
        assertThat(values).contains(3);
        // 2. assert 1,3,4,2,5 are in the list
        assertThat(values).containsExactly(1, 3, 4, 2, 5);
        // 3. assert 1,2,3,4,5 are in the list
        assertThat(values).containsExactlyInAnyOrder(1, 2, 3, 4, 5);
    }

    @Test
    void contains_objects() {
        // arrange
        Person peter = new Person("Peter", "Maler", 42);
        Person fritz = new Person("Fritz", "Meier", 5);
        List<Person> values = Arrays.asList(peter, fritz);

        // assert
        // 1. assert fritz is present
        assertThat(values).contains(fritz);
        // 2. assert peter, fritz are in the list
        assertThat(values).containsExactly(peter, fritz);
        // 3. assert fritz, peter are in the list
        assertThat(values).containsExactlyInAnyOrder(fritz, peter);
        // 4. assert first and last name of the persons in the list.
        assertThat(values).extracting(Person::getFirstName, Person::getLastName)
                .contains(
                        tuple("Peter", "Maler"),
                        tuple("Fritz", "Meier")
                );
    }
}
