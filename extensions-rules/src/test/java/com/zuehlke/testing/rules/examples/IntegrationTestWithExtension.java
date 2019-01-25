package com.zuehlke.testing.rules.examples;

import com.zuehlke.testing.rules.Person;
import com.zuehlke.testing.rules.PersonDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PersonResourceExtension.class)
class IntegrationTestWithExtension {

    private PersonDao dao = new PersonDao();

    @Test
    void find_withRule(PersonResource personResource) {
        // arrange
        Person expected = personResource.createPerson("Smarty");
        // act
        Person result = dao.find(expected.getName());
        // assert
        assertThat(result.getName(), is(equalTo(expected.getName())));
    }
}

