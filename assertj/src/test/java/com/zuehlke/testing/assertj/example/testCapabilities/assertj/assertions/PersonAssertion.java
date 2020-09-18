package com.zuehlke.testing.assertj.example.testCapabilities.assertj.assertions;

import com.zuehlke.testing.assertj.example.domain.people.Person;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Condition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.condition.AllOf.allOf;

public class PersonAssertion extends AbstractAssert<PersonAssertion, Person> {

    public PersonAssertion(Person person, Class<?> selfType) {
        super(person, selfType);
    }

    public static PersonAssertion assertThatPerson(Person actual) {
        return new PersonAssertion(actual, PersonAssertion.class);
    }

    public PersonAssertion hasFirstName(String expected) {
        return satisfies(havingFirstName(expected));
    }

    public PersonAssertion hasLastName(String expected) {
        return satisfies(havingLastName(expected));
    }

    public PersonAssertion isNamed(String firstName, String lastName) {
        return satisfies(allOf(havingFirstName(firstName), havingLastName(lastName)));
    }

    public PersonAssertion isAged(int expectedAge) {
        return satisfies(person -> assertThat(person.getAge()).describedAs("the person's age").isEqualTo(expectedAge));
    }

    public PersonAssertion isTeenager() {
        if (actual.getAge() >= 20) {
            failWithMessage("%s is not a teenager, because this person is 20 or older. Actual age: %s",
                    actual, actual.getAge());
        }

        return this;
    }


    private static Condition<Person> havingFirstName(String expected) {

        return new Condition<>(person -> person.getFirstName().equals(expected),
                "First name should be <%s>.", expected);
    }

    private static Condition<Person> havingLastName(String expected) {

        return new Condition<>(person -> person.getLastName().equals(expected),
                "Last name should be <%s>.", expected);
    }

}
