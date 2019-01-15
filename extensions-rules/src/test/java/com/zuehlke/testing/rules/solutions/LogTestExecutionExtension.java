package com.zuehlke.testing.rules.solutions;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LogTestExecutionExtension implements BeforeTestExecutionCallback {
    @Override
    public void beforeTestExecution(ExtensionContext context) {
        System.out.println(context.getTestClass().get().getCanonicalName() + ": " +context.getDisplayName());
    }
}
