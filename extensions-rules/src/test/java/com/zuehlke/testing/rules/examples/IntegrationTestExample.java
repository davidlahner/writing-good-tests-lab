package com.zuehlke.testing.rules.examples;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;

import com.zuehlke.testing.rules.Person;
import com.zuehlke.testing.rules.PersonDao;

class IntegrationTestExample {

	private PersonDao dao = new PersonDao();

	@Test
	void find_oldStyle() {
		// arrange
		Person expected = new Person("Dummy");
		dao.save(expected);
		try {
			// act
			Person person = dao.find(expected.getName());
			// assert
			assertThat(person.getName(), is(equalTo(expected.getName())));
		} finally {
			// cleanup
			dao.delete(expected);
		}
	}
}
