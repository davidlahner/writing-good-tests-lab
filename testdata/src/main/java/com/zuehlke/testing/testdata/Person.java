package com.zuehlke.testing.testdata;

public class Person {
    private final String firstName;
    private final String familyName;
    private final String street;
    private final String zipCode;
    private final String city;

    public Person(String firstName, String familyName, String street, String zipCode, String city) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }
}
