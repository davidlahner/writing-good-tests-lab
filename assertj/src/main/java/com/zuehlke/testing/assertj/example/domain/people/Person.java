package com.zuehlke.testing.assertj.example.domain.people;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName) {
        this(firstName, lastName, 42);
    }

    public Person(String firstName, String lastName, int age) {

        requireNonNegative(age);

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    private void requireNonNegative(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(String.format("Age must not be negative but was <%s>", age));
        }
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public int getAge() {

        return age;
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("age", age)
                .toString();
    }
}
