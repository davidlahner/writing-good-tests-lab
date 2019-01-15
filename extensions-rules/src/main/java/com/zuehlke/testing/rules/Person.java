package com.zuehlke.testing.rules;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	private long id;
	private String name;

	public Person(String name) {
		super();
		if (name == null) {
			throw new IllegalArgumentException("Name must not be null");
		}
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" + "name=" + name + '}';
	}

	public String getName() {
		return name;
	}
}