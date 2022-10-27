package com.zuehlke.testing.fuzzing.example;

import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith(JQF.class)
public class BuggyCodeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuggyCodeTest.class);

    @Fuzz
    public void testDivision(int a, int b) {
        try {
            new BuggyCode().division(a, b);
        } catch (Exception e) {
            LOGGER.warn(String.format("Test failure with input a=%s, b=%s.", a, b), e);
            throw e;
        }
    }
}