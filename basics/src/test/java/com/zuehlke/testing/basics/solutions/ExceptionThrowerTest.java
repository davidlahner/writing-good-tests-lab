package com.zuehlke.testing.basics.solutions;

import com.zuehlke.testing.basics.exercises.ExceptionThrower;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionThrowerTest {

    private final ExceptionThrower testee = new ExceptionThrower();

    @Test
    void testThrowRuntimeException_illegalParameter_illegalArgumentMessage() {
        // act
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> testee.throwRuntimeException(-1));

        //assert
        assertThat(exception.getMessage()).startsWith("Illegal argument");
    }

    @Test
    void testThrowRuntimeException_legalParameter_runtimeMessage() {
        // act
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> testee.throwRuntimeException(1));

        //assert
        assertThat(exception.getMessage()).isEqualTo("Runtime exception occurred");
    }

    @Test
    void testThrowExceptionWithCause_expectCauseType() {
        // act
        RuntimeException exception = assertThrows(RuntimeException.class,
                testee::throwExceptionWithCause);

        //assert
        assertThat(exception.getMessage()).isEqualTo("outer exception");
        assertThat(exception.getCause()).isInstanceOf(NullPointerException.class);
    }

    @Test
    void testThrowExceptionWithCause_expectCauseWithMessage() {
        // act
        RuntimeException exception = assertThrows(RuntimeException.class,
                testee::throwExceptionWithCause);

        //assert
        assertThat(exception.getMessage()).isEqualTo("outer exception");
        assertThat(exception.getCause())
                .is(matchingType(NullPointerException.class))
                .is(matchingMessage("Oops! Something wasn't supposed to be null here."));
    }

    private Condition<Throwable> matchingType(Class<? extends Throwable> expectedType) {
        return new Condition<>((Throwable thrown) -> expectedType.isAssignableFrom(thrown.getClass()),
                "exception of type %s", expectedType);
    }

    private Condition<Throwable> matchingMessage(String expectedMessage) {
        return new Condition<>((Throwable thrown) -> expectedMessage.equals(thrown.getMessage()),
                "exception with message %s", expectedMessage);
    }
}
