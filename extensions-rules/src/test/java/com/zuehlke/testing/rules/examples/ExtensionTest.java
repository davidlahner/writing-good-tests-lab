package com.zuehlke.testing.rules.examples;

import org.junit.jupiter.api.*;
import org.junit.Rule;

import com.zuehlke.testing.rules.LoggingExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(LoggingExtension.class)
class ExtensionTest {

	@BeforeAll
	static void beforeClass() {
		System.out.println("before class");
	}

	@AfterAll
	static void afterClass() {
		System.out.println("after class");
	}

	@BeforeEach
	void beforeTest() {
		System.out.println("before test");
	}

	@AfterEach
	void afterTest() {
		System.out.println("after test");
	}

	@Test
	void test1() {
		System.out.println("In Test1");
	}

	@Test
	void test2() {
		System.out.println("In Test2");
	}
}

