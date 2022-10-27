package com.zuehlke.testing.testdata.examples;

import com.zuehlke.testing.testdata.RegistrationService;
import org.junit.jupiter.api.RepeatedTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class JavaFakerDemoTest {
    private final RegistrationService testee = new RegistrationService();

    @RepeatedTest(10)
    void testRegister(){
        //arrange

        //act
        String actual = testee.register(null);

        //assert
        assertThat(actual).isNotEmpty();
    }

    @RepeatedTest(10)
    void testRegisterEmail(){
        //arrange

        //act
        testee.registerEMail(UUID.randomUUID().toString(), null);
    }
}
