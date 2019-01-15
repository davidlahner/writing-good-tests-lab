package com.zuehlke.testing.rules.solutions;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.TemporaryFolder;

import com.zuehlke.testing.rules.exercises.LogWriter;

@EnableRuleMigrationSupport
public class LogWriterTest {

	private LogWriter testee = new LogWriter();

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void log() throws IOException {
		// arrange
		File logFile = tempFolder.newFile("logFile.txt");
		// act
		testee.log(logFile, "Hello Log");
		// assert
		String result = new String(Files.readAllBytes(logFile.toPath()));
		assertThat(result, containsString("Hello Log"));
	}
}
