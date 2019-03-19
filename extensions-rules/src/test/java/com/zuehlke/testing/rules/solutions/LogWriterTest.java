package com.zuehlke.testing.rules.solutions;

import com.zuehlke.testing.rules.exercises.LogWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class LogWriterTest {

    private LogWriter testee = new LogWriter();

    @Test
    void log(@TempDir Path tempDir) throws IOException {
        // arrange
        Path filePath = tempDir.resolve("logFile.txt");
        File logFile = new File(filePath.toUri());
        // act
        testee.log(logFile, "Hello Log");
        // assert
        String result = new String(Files.readAllBytes(logFile.toPath()));
        assertThat(result, containsString("Hello Log"));
    }
}
