package com.zuehlke.testing.assertj.example.testCapabilities;

import com.zuehlke.testing.assertj.example.domain.events.Event;
import com.zuehlke.testing.assertj.example.domain.events.EventBus;
import com.zuehlke.testing.assertj.example.domain.events.SomethingGoodHappened;
import com.zuehlke.testing.assertj.example.domain.explosives.Bomb;
import com.zuehlke.testing.assertj.example.domain.explosives.BombExploded;
import com.zuehlke.testing.assertj.example.domain.explosives.OxyhydrogenExplosion;
import com.zuehlke.testing.assertj.example.domain.people.Person;
import com.zuehlke.testing.assertj.example.testCapabilities.assertj.assertions.EventTestHabits;
import com.zuehlke.testing.assertj.example.testCapabilities.assertj.assertions.ExplosivesTestHabits;
import com.zuehlke.testing.assertj.example.testCapabilities.assertj.assertions.PersonTestHabits;
import com.zuehlke.testing.assertj.example.testCapabilities.assertj.hamcrest.HamcrestMatcherHabits;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.zuehlke.testing.assertj.example.testCapabilities.assertj.assertions.PersonAssertion.assertThatPerson;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;


class AssertJDemo implements PersonTestHabits, ExplosivesTestHabits {

    @Nested
    class Basics {

        @Test
        void has_a_readable_fluent_interface_for_the_basic_assertions() {

            String aString = "AssertJ rocks!";

            assertThat(aString)
                    .isEqualTo("AssertJ rocks!")
                    .isNotSameAs("AssertJ rocks")
                    .isNotEqualTo("Hamcrest")
                    .isNotNull()
                    .contains("AssertJ")
                    .containsIgnoringCase("assertj")
                    .startsWith("Assert")
                    .endsWith("rocks!")
                    .isInstanceOf(String.class)
                    .isNotBlank();

            // + Easy to discover all available assertion methods
            // + Less noise due to fluent interface

            Person aPerson = new Person("Some", "One", 42);
            assertThat(aPerson.getAge())
                    .isGreaterThan(20)
                    .isLessThan(50)
                    .isEqualTo(42);

            // + You get the set of assertions that is applicable for the type
            // of the object that gets asserted.

            assertThat(aPerson).hasToString("Person[firstName=Some,lastName=One,age=42]");

            Object anObject = new Person("Some", "Body", 19);

            assertThat(anObject).isInstanceOfSatisfying(Person.class, (Person person) -> {
                assertThat(person.getFirstName()).isEqualTo("Some");
                assertThat(person.getAge()).isBetween(10, 20);
            });
        }

        @Test
        void hard_to_read() {
            // given:
            EventBus theEventBus = new EventBus();

            // when:
            List<Event> theEvents = theEventBus.events();

            // then:
            assertThat(theEvents).satisfies(the ->
                    assertThat(the).isInstanceOfSatisfying(SomethingGoodHappened.class,
                            it -> assertThat(it.good()).isEqualTo("AssertJ rocks!")), atIndex(0));
        }

        @Test
        void temporal_assertions() {
            // given:
            LocalDateTime from = LocalDateTime.parse("2019-11-14T09:00");

            // then:
            assertThat(from)
                    .isAfter("2019-11-11T11:11")
                    .isBefore("2020-01-01T00:00")
                    .isBetween("2019-11-11T11:11", "2020-01-01T00:00");
        }

        @Test
        void assertions_in_domain_language_using_Conditions() {
            // given:
            Person bob = new Person("Bob", "Smith", 20);

            // then:
            assertThat(bob)
                    .is(anAdult())
                    .is(aged(20))
                    .is(personNamed("Bob", "Smith"))
                    .is(havingFirstName("Bob"))
                    .is(havingLastName("Smith"));

            // + More expressive because it uses domain language
            // + Less coupling to details of the domain object
            // + Modular. Conditions can be reused in other contexts.
            //   For example in collection assertions.
        }

        @Test
        void bad_assertions_no_domain_language() {

            Person bob = new Person("Bob", "Smith", 19);

            assertThat(bob.getAge()).as("is an adult").isGreaterThanOrEqualTo(18);
            assertThat(bob.getAge()).as("age").isEqualTo(19);
            assertThat(bob.getFirstName()).as("first name").isEqualTo("Bob");
            assertThat(bob.getLastName()).as("last name").isEqualTo("Smith");

        }

        @Test
        void supports_BDD_style_assertions() {
            // given:
            Person bob = new Person("Bob", "Smith", 19);

            then(bob).is(anAdult())
                    .is(aged(19))
                    .is(personNamed("Bob", "Smith"))
                    .is(havingFirstName("Bob"))
                    .is(havingLastName("Smith"));

            // Syntactic sugar. Use then(...) instead of assertThat(...)
        }

        @Test
        void assertions_in_domain_language_with_custom_assertion() {
            // given:
            Person bob = new Person("Bob", "Smith", 19);

            // then:
            assertThatPerson(bob)
                    .isNotNull()
                    .is(personNamed("Bob", "Smith"))
                    .isTeenager()
                    .isAged(19)
                    .isNamed("Bob", "Smith")
                    .hasFirstName("Bob")
                    .hasLastName("Smith");

            // + Fluent interface, easy to discover
            //
            // - Awkward to reuse in other contexts, like collection assertions. Conditions are more modular.

            // Some generic assertion methods come for free on the custom assertion:
            assertThatPerson(bob)
                    .isNotNull()
                    .isInstanceOf(Person.class)
                    .is(personNamed("Bob", "Smith"));
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
            PersonJson parsed = parsePersonFromJson(json);

            // then:
            assertThat(new Person("Bob", "Smith", 42))
                    .usingRecursiveComparison().isEqualTo(parsed);

            // If you have a nested data structure, use this:
            assertThat(parsed)
                    .usingRecursiveComparison()
                    .isEqualTo(new Person("Bob", "Smith", 42));
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
            assertThat(somePioneers).describedAs("Pioneers of computer science")
                    .extracting(Person::getFirstName, Person::getLastName, Person::getAge)
                    .containsExactlyInAnyOrder(
                            tuple("Ada", "Lovelace", 203),
                            tuple("Alan", "Turing", 107)
                    );

            // + Quick, without any custom assertion code
            // + Refactoring safe
            //
            // - Technical: extracting, tuple
            // - Non Local, need to correlate tuple elements with elements of the extracting clause in order to
            //   understand the tuples.

        }

        @Test
        void matching_a_collection_of_objects() {
            // given:
            Person ada = new Person("Ada", "Lovelace", 203);
            Person alan = new Person("Alan", "Turing", 107);
            List<Person> somePioneers = asList(ada, alan);

            Set<Person> morePioneeres = new HashSet<>();
            morePioneeres.add(alan);
            morePioneeres.add(ada);

            // expect:
            assertThat(somePioneers).describedAs("Pioneers of computer science")
                    .hasSize(2)
                    .contains(alan)
                    .contains(ada)
                    .containsExactlyInAnyOrder(alan, ada)
                    .containsExactly(ada, alan)
                    .contains(alan, atIndex(1));
        }

        @Test
        void match_by_properties__Domain_language_style() {
            // given:
            Person ada = new Person("Ada", "Lovelace", 203);
            Person alan = new Person("Alan", "Turing", 107);
            List<Person> somePioneers = asList(ada, alan);

            // expect
            assertThat(somePioneers).describedAs("Pioneers of computer science")
                    .hasSize(2)
                    .haveExactly(1, allOf(personNamed("Ada", "Lovelace"), aged(203)))
                    .haveExactly(1, allOf(personNamed("Alan", "Turing"), aged(107)));

            // + Self explaining
            //
            // - Needs custom condition
        }

        @Test
        void match_by_properties_in_exact_order() {
            // given:
            Person ada = new Person("Ada", "Lovelace");
            Person alan = new Person("Alan", "Turing");
            List<Person> somePioneers = asList(ada, alan);

            // expect
            assertThat(somePioneers).describedAs("Pioneers of computer science")
                    .hasSize(2)
                    .has(personNamed("Ada", "Lovelace"), atIndex(0))
                    .has(personNamed("Alan", "Turing"), atIndex(1));

        }
    }

    @ExtendWith(SoftAssertionsExtension.class)
    class TheSoftAssertions {

        @Test
        void supports_grouped_assertions(SoftAssertions softly) {

            Person thePerson = new Person("John", "Doe", 42);

            softly.assertThat(thePerson.getFirstName()).as("First name").isEqualTo("John");
            softly.assertThat(thePerson.getLastName()).as("Last name").isEqualTo("Doe");
            softly.assertThat(thePerson.getAge()).as("Age").isEqualTo(42);

            // Alternatively
            softly.assertThat(thePerson)
                    .is(havingFirstName("John"))
                    .is(havingLastName("Doe"))
                    .is(aged(42));

            // Alternatively, use JUnit5 grouped assertions if you don't like SoftAssertions.
            assertAll("The Person",
                    () -> assertThat(thePerson).is(havingFirstName("John")),
                    () -> assertThat(thePerson).is(havingLastName("Doe")),
                    () -> assertThat(thePerson).is(aged(42))
            );
        }
    }

    @Nested
    @ExtendWith(SoftAssertionsExtension.class)
    class ExceptionAssertions {

        @Test
        void asserts_exceptions() {
            // given:
            Bomb theBomb = Bomb.create().armed();

            // when:
            BombExploded thrown = catchThrowableOfType(theBomb::shake, BombExploded.class);

            assertThat(thrown)
                    .isNotNull() // Awkward!
                    .hasMessage("Boom!")
                    .hasCauseInstanceOf(OxyhydrogenExplosion.class);

            // Unfortunately, the ThrowableAssertions object looses the exact type information.
            assertThat(thrown.explosives()).as("Explosives").isEqualTo("Oxyhydrogen");
        }

        @Test
        void recommended_style() {
            // given:
            Bomb theBomb = Bomb.create().armed();

            // when:
            // Use JUnit5 here
            BombExploded thrown = assertThrows(BombExploded.class, theBomb::shake);

            // Assert with condition for the custom exception properties
            assertThat(thrown)
                    .hasMessage("Boom!")
                    .hasCauseInstanceOf(OxyhydrogenExplosion.class)
                    .is(havingExplosives("Oxyhydrogen"));
        }

        @Test
        void asserts_exception_with_expectation_style() {
            // given:
            Bomb theBomb = Bomb.create().armed();

            // expect:
            assertThatThrownBy(theBomb::shake)
                    .hasMessage("Boom!")
                    .hasCauseInstanceOf(OxyhydrogenExplosion.class)
                    .is(havingExplosives("Oxyhydrogen"));

        }

        @Test
        void assert_that_something_is_not_thrown() {
            // given:
            Bomb theBomb = Bomb.create().disarmed();

            // expect
            assertThatCode(theBomb::shake).doesNotThrowAnyException();

            // Better use JUnit5
            assertDoesNotThrow(theBomb::shake);
        }
    }

    @Nested
    class MockitoIntegration implements HamcrestMatcherHabits, EventTestHabits {

        @Test
        void parameter_assertions() {
            // setup:
            EventBus theEventBus = mock(EventBus.class);

            // when:
            theEventBus.send(new SomethingGoodHappened());

            // then:
            verify(theEventBus).send(argThat(is(eventOfType(SomethingGoodHappened.class))));

            verify(theEventBus).send(argThat(satisfies(
                    event -> assertThat(event).isInstanceOfSatisfying(SomethingGoodHappened.class,
                            the -> assertThat(the.good()).isEqualTo("AssertJ rocks!"))
            )));
        }

    }
}
