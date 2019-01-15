package com.zuehlke.testing.mocking.person;

import java.util.List;

public class PersonService {
	private final PersonDao dao;

    public PersonService(PersonDao dao) {
        this.dao = dao;
    }

    public List<Person> findAll() {
        return dao.findAll();
    }

    public Person findById(int id) {
        return dao.findById(id);
    }

}
