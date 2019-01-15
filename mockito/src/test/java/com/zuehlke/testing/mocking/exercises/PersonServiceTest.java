package com.zuehlke.testing.mocking.exercises;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.zuehlke.testing.mocking.person.PersonService;

public class PersonServiceTest {

	private PersonService testee;

	/**
	 * Excercises:
	 * 
	 * Return Value: Write a Test that returns a valid person for a call to the
	 * method findById(1). What happens if you call findById(2)?
	 * 
	 * Exception: Write a Test that verifies valid ids. For negative ids an
	 * IllegalArgumentException should be thrown.
	 * 
	 * Method Called: Write a Test that verifies if a special method was called. The
	 * desired result is a list with two persons.
	 * 
	 * Call Count: Write a Test that verifies the number of calls for the code
	 * snippet below for findById() and findAll() � check only for id 1 for exact
	 * match.
	 */

	// Exercise CALL-COUNT
	@Disabled
	// TODO implement test
	@Test
	public void findById_multipleCalls_callCountVerfied() {
		// Act
		testee.findById(11);
		testee.findAll();
		testee.findById(1);
		testee.findById(2);

		// assert
	}
}
