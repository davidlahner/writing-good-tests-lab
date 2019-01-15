package com.zuehlke.testing.hamcrest;

public class Person {

	private int id;
	private String firstname;
	private String lastname;
	private int age;

	public Person(int id, String firstname, String lastname, int age) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + ", age="
				+ age + '}';
	}
}