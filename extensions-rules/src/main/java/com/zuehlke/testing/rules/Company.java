package com.zuehlke.testing.rules;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	private long id;
	private String name;

	public Company(String name) {
		super();
		if (name == null) {
			throw new IllegalArgumentException("Name must not be null");
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Company{" + "name=" + name + '}';
	}
}