package com.zuehlke.testing.rules.examples;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Rule;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.rules.Timeout;

import com.zuehlke.testing.rules.Person;
import com.zuehlke.testing.rules.PersonDao;

@Disabled
//TODO: remove @Disabled to run test
public class TimeoutExample {

	private PersonDao dao = new PersonDao();

	@RegisterExtension
	public PersonResource personResource = new PersonResource();

	@Rule
	public Timeout globalTimeout = new Timeout(2, TimeUnit.SECONDS);

	private Person expected;

	@BeforeEach
	public void init() {
		expected = personResource.createPerson("Test");
	}

	@Test
	public void fastQuery_withoutTimeout() {
		// act
		Person result = dao.find("Test");
		// assert
		assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void complexQuery_withTimeout() {
		// act
		Person result = assertTimeout(Duration.ofSeconds(2), () -> dao.longLastingQuery("Test"));
		// assert
		assertThat(result, is(equalTo(expected)));
	}


	@Test
	public void complexQuery_withPreemptiveTimeout() {
		// act
		Person result = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> dao.longLastingQuery("Test"));
		// assert
		assertThat(result, is(equalTo(expected)));
	}
}
