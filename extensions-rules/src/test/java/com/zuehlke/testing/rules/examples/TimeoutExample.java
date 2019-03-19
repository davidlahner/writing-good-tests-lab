package com.zuehlke.testing.rules.examples;

import com.zuehlke.testing.rules.Person;
import com.zuehlke.testing.rules.PersonDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@Disabled
//TODO: remove @Disabled to run test
class TimeoutExample {

    private PersonDao dao = new PersonDao();

    @RegisterExtension
    private PersonResource personResource = new PersonResource();

    private Person expected;

    @BeforeEach
    void init() {
        expected = personResource.createPerson("Test");
    }

    @Test
    void fastQuery_withoutTimeout() {
        // act
        Person result = dao.find("Test");
        // assert
        assertThat(result, is(equalTo(expected)));
    }

    @Test
    void complexQuery_withTimeout() {
        // act
        Person result = assertTimeout(Duration.ofSeconds(2), () -> dao.longLastingQuery("Test"));
        // assert
        assertThat(result, is(equalTo(expected)));
    }


    @Test
    void complexQuery_withPreemptiveTimeout() {
        // act
        Person result = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> dao.longLastingQuery("Test"));
        // assert
        assertThat(result, is(equalTo(expected)));
    }
}
