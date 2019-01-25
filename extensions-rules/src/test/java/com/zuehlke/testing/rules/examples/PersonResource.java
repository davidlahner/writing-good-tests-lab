package com.zuehlke.testing.rules.examples;


import com.zuehlke.testing.rules.Person;
import com.zuehlke.testing.rules.PersonDao;

import java.util.ArrayList;
import java.util.List;

public class PersonResource {

    private List<Person> people = new ArrayList<>();
    private PersonDao dao = new PersonDao();

    public Person createPerson(String name) {
        final Person person = new Person(name);
        dao.save(person);
        people.add(person);
        return person;
    }

    void cleanUp() {
        for (Person person : people) {
            dao.delete(person);
        }
    }
}


