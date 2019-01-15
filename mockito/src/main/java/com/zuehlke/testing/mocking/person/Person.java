package com.zuehlke.testing.mocking.person;

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

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + ", age="
				+ age + '}';
	}
}