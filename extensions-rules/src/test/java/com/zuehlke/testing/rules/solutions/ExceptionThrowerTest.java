package com.zuehlke.testing.rules.solutions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;

import com.zuehlke.testing.rules.exercises.ExceptionThrower;

@ExtendWith(LogTestExecutionExtension.class)
public class ExceptionThrowerTest {

	private ExceptionThrower testee = new ExceptionThrower();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testThrowRuntimeException_illegalParameter_illegalArgumentMessage() {
		// act
		RuntimeException exception = assertThrows(RuntimeException.class, () -> testee.throwRuntimeException(-1));

		//assert
		assertThat(exception.getMessage(),startsWith("Illegal argument"));
	}

	@Test
	public void testThrowRuntimeException_legalParameter_runtimeMessage() {
		// act
		RuntimeException exception = assertThrows(RuntimeException.class, () -> testee.throwRuntimeException(1));

		//assert
		assertThat(exception.getMessage(),is(equalTo("Runtime exception occurred")));
	}

	@Test
	public void testThrowExceptionWithCause_expectCauseType() throws Exception {
		// act
		RuntimeException exception = assertThrows(RuntimeException.class, () -> testee.throwExceptionWithCause());

		//assert
		assertThat(exception.getMessage(),is(equalTo("outer exception")));
		assertThat(exception.getCause(), instanceOf(NullPointerException.class));
	}

	@Test
	public void testThrowExceptionWithCause_expectCauseWithMessage() throws Exception {
		// act
		RuntimeException exception = assertThrows(RuntimeException.class, () -> testee.throwExceptionWithCause());

		//assert
		assertThat(exception.getMessage(),is(equalTo("outer exception")));
		assertThat(exception.getCause(), CauseMatcher.matchesCause(NullPointerException.class,
				"Oops! Something wasn't supposed to be null here."));
	}

	private static class CauseMatcher extends TypeSafeMatcher<Throwable> {

		private final Class<? extends Throwable> type;
		private final String expectedMessage;

		private CauseMatcher(Class<? extends Throwable> type, String expectedMessage) {
			this.type = type;
			this.expectedMessage = expectedMessage;
		}

		@Override
		protected boolean matchesSafely(Throwable item) {
			return item.getClass().isAssignableFrom(type) && item.getMessage().contains(expectedMessage);
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("expects type ").appendValue(type).appendText(" and a message ")
					.appendValue(expectedMessage);
		}

		public static CauseMatcher matchesCause(Class<? extends Throwable> type, String expectedMessage) {
			return new CauseMatcher(type, expectedMessage);
		}
	}

}