package com.zuehlke.testing.rules;

import org.junit.jupiter.api.extension.*;

public class LoggingExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback {

	@Override
	public void beforeAll(ExtensionContext context) {
		System.out.println("before all extension");
	}

	@Override
	public void beforeEach(ExtensionContext context) {
		System.out.println("before extension");
	}

	@Override
	public void beforeTestExecution(ExtensionContext context) {
		System.out.println("before execution extension");
	}

	@Override
	public void afterTestExecution(ExtensionContext context) {
		System.out.println("after execution extension");
	}

	@Override
	public void afterEach(ExtensionContext context) {
		System.out.println("after extension");
	}

	@Override
	public void afterAll(ExtensionContext context) {
		System.out.println("after all extension");
	}
}
