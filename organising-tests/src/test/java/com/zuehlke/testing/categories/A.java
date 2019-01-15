package com.zuehlke.testing.categories;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class A {
	@Test
	void a() {
	}

	@Tag("fast")
	@Test
	void b() {
	}

	@Fast
	@Test
	void c() {
	}
}
