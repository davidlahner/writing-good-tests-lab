package com.zuehlke.testing.testdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class RegistrationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationService.class);

    public String register(Person person) {
        LOGGER.info("{} {} registered with Address {} {} {}",
                person.getFirstName(), person.getFamilyName(),
                person.getStreet(), person.getZipCode(), person.getCity());
        return UUID.randomUUID().toString();
    }

    public void registerEMail(String personId, String email) {
        LOGGER.info("E-Mail {} registered for person {}.", email, personId);
    }
}
