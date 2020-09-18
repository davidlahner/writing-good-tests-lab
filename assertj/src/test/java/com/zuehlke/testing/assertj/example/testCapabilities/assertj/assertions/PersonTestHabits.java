package com.zuehlke.testing.assertj.example.testCapabilities.assertj.assertions;

import com.google.gson.Gson;
import com.zuehlke.testing.assertj.example.domain.people.Person;
import org.assertj.core.api.Condition;

import static org.assertj.core.condition.AllOf.allOf;

public interface PersonTestHabits {

    default Condition<Person> havingFirstName(String expected) {

        return new Condition<>(person -> person.getFirstName().equals(expected),
                "First name should be <%s>.", expected);
    }

    default Condition<Person> havingLastName(String expected) {

        return new Condition<>(person -> person.getLastName().equals(expected),
                "Last name should be <%s>.", expected);
    }

    default Condition<Person> personNamed(String firstName, String lastName) {

        return allOf(havingFirstName(firstName), havingLastName(lastName));
    }

    default Condition<Person> anAdult() {
        return new Condition<>(person -> person.getAge() >= 18, "an adult, so at least 18 years old");
    }

    default Condition<Person> aged(int expected) {
        return new Condition<>(person -> person.getAge() == expected, "aged %s", expected);
    }

    default PersonJson parsePersonFromJson(String json) {
        return new Gson().fromJson(json, PersonJson.class);
    }

    class PersonJson {

        public String firstName;
        public String lastName;
        public Integer age;


    }

}
