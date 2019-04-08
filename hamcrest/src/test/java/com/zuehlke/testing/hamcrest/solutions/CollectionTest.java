package com.zuehlke.testing.hamcrest.solutions;

import com.zuehlke.testing.hamcrest.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CollectionTest {

    @Test
    void contains_primitives() {
        // arrange
        List<Integer> values = Arrays.asList(1, 3, 4, 2, 5);

        // assert
        // 1. assert 3 is present
        assertThat(values, hasItem(3));
        // 2. assert 1,3,4,2,5 are in the list
        assertThat(values, contains(1, 3, 4, 2, 5));
        // 3. assert 1,2,3,4,5 are in the list
        assertThat(values, containsInAnyOrder(1, 2, 3, 4, 5));
    }

    @Test
    void contains_objects() {
        // arrange
        Person peter = new Person(1, "Peter", "Maler", 42);
        Person fritz = new Person(2, "Fritz", "Meier", 5);
        List<Person> values = Arrays.asList(peter, fritz);

        // assert
        // 1. assert fritz is present
        assertThat(values, hasItem(fritz));
        // 2. assert new Person(2, "Fritz", "Meier", 5) is present
        assertThat(values, hasItem(samePropertyValuesAs(new Person(2, "Fritz", "Meier", 5))));
        // 3. assert peter, fritz are in the list
        assertThat(values, contains(peter, fritz));
        // 4. assert fritz, peter are in the list
        assertThat(values, containsInAnyOrder(fritz, peter));
    }
}
