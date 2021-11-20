package com.zuehlke.testing.assertj.demo;

import com.zuehlke.testing.assertj.example.domain.people.Person;
import com.zuehlke.testing.assertj.example.testCapabilities.assertj.assertions.ExplosivesTestHabits;
import com.zuehlke.testing.assertj.example.testCapabilities.assertj.assertions.PersonTestHabits;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class AssertJDemoSkeleton implements PersonTestHabits, ExplosivesTestHabits {
    @Nested
    class Basics {

        @Test
        void has_a_readable_fluent_interface_for_the_basic_assertions() {

            String aString = "AssertJ rocks!";


            Person aPerson = new Person("Some", "One", 42);


            Object anObject = new Person("Some", "Body", 19);

        }

        @Test
        void temporal_assertions() {
            // given:
            LocalDateTime from = LocalDateTime.parse("2019-11-14T09:00");

            // then:
        }


        @Test
        void generic_property_comparison() {
            // given:
            String json = "{\n" +
                    "  \"firstName\": \"Bob\",\n" +
                    "  \"lastName\": \"Smith\",\n" +
                    "  \"age\": 42\n" +
                    "}";

            // when:
            PersonTestHabits.PersonJson parsed = parsePersonFromJson(json);

        }

    }


    @Nested
    class CollectionMatching {

        @Test
        void match_by_properties__Generic_style() {
            // given:
            Person ada = new Person("Ada", "Lovelace", 203);
            Person alan = new Person("Alan", "Turing", 107);
            List<Person> somePioneers = asList(ada, alan);

            // expect:

        }

        @Test
        void matching_a_collection_of_objects() {
            // given:
            Person ada = new Person("Ada", "Lovelace", 203);
            Person alan = new Person("Alan", "Turing", 107);
            List<Person> somePioneers = asList(ada, alan);

            Set<Person> morePioneeres = Set.of(alan, ada);

            // expect:
        }

    }

}
