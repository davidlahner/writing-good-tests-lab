package com.zuehlke.testing.assertj.example;


import com.zuehlke.testing.assertj.example.domain.people.Person;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Disabled
public class ErrorMessagesExample {

    private final Person mike = new Person("Mike", "Tester", 38);

    @Test
    public void errorMessageJUnit() {
        assertThat(mike.getAge() > 30 && mike.getAge() % 2 != 0)
                .isTrue();
    }

    @Test
    public void errorMessageJUnitWithMessage() {
        assertThat(mike.getAge() > 30 && mike.getAge() % 2 != 0)
                .withFailMessage("age>30 and odd, but was %d", mike.getAge())
                .isTrue();
    }

    @Test
    public void errorMessageJUnitWithAssertAll() {
        assertAll("mike",
                () -> assertThat(mike.getAge())
                        .withFailMessage("age > 30")
                        .isGreaterThan(30),
                () -> assertThat(mike.getAge() % 2)
                        .withFailMessage("age odd")
                        .isNotEqualTo(0)
        );
    }

    @Test
    public void errorMessageAssertJ() {
        assertThat(mike.getAge())
                .isGreaterThan(30)
                .doesNotHave(evenNumberCondition());
    }

    private Condition<Integer> evenNumberCondition() {
        return new Condition<>(age -> age % 2 == 0, "even number");
    }

    @Test
    public void errorMessageAssertJIsOdd() {
        assertThat(mike.getAge())
                .isGreaterThan(30)
                .isOdd();
    }
}
