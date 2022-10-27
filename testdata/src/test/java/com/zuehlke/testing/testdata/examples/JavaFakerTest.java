package com.zuehlke.testing.testdata.examples;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.zuehlke.testing.testdata.Person;
import com.zuehlke.testing.testdata.RegistrationService;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Locale;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class JavaFakerTest {
    private final RegistrationService testee = new RegistrationService();

    @RepeatedTest(10)
    void testRegister(){
        //arrange
        Faker faker = new Faker(Locale.GERMAN);

        Name name = faker.name();
        Address address = faker.address();
        Person person = new Person(
                name.firstName(),  name.lastName(),
                address.streetAddress(), address.zipCode(), address.city());

        //act
        String actual = testee.register(person);

        //assert
        assertThat(actual).isNotEmpty();
    }

    @RepeatedTest(10)
    void testRegisterEmail(){
        //arrange
        FakeValuesService fakeValuesService = new FakeValuesService(Locale.GERMAN, new RandomService());
        String email = fakeValuesService.bothify("????##@gmail.com");

        //act
        testee.registerEMail(UUID.randomUUID().toString(), email);
    }

}
