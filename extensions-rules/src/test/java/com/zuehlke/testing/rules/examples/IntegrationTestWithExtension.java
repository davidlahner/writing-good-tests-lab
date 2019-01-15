package com.zuehlke.testing.rules.examples;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;

import com.zuehlke.testing.rules.Person;
import com.zuehlke.testing.rules.PersonDao;
import org.junit.jupiter.api.extension.RegisterExtension;

class IntegrationTestWithExtension {

    private PersonDao dao = new PersonDao();

    @RegisterExtension
    private PersonResource personResource = new PersonResource();

    @Test
    void find_withRule() {
        // arrange
        Person expected = personResource.createPerson("Smarty");
        // act
        Person result = dao.find(expected.getName());
        // assert
        assertThat(result.getName(), is(equalTo(expected.getName())));
    }
}

