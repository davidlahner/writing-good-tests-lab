package com.zuehlke.testing.basics.exercises;

public class ExceptionThrower {

    public void throwRuntimeException(int i) {
        if (i <= 0) {
            throw new RuntimeException("Illegal argument: parameter must be <= 0");
        }
        throw new RuntimeException("Runtime exception occurred");
    }

    public void throwExceptionWithCause() {
        throw new RuntimeException("outer exception",
                new NullPointerException("Oops! Something wasn't supposed to be null here."));
    }
}
