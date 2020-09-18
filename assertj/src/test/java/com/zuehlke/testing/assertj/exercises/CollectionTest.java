package com.zuehlke.testing.assertj.exercises;

import com.zuehlke.testing.assertj.example.domain.people.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CollectionTest {

    @Test
    public void contains_primitives() {
        // arrange
        List<Integer> values = Arrays.asList(1, 3, 4, 2, 5);

        // assert
        // 1. assert 3 is present
        // 2. assert 1,3,4,2,5 are in the list
        // 3. assert 1,2,3,4,5 are in the list
    }

    @Test
    public void contains_objects() {
        // arrange
        Person peter = new Person("Peter", "Maler", 42);
        Person fritz = new Person("Fritz", "Meier", 5);
        List<Person> values = Arrays.asList(peter, fritz);

        // assert
        // 1. assert fritz is present
        // 2. assert peter, fritz are in the list
        // 3. assert fritz, peter are in the list
        // 4. assert first and last name of the persons in the list.
    }
}
