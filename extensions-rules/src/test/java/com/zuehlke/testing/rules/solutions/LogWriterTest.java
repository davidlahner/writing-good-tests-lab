package com.zuehlke.testing.rules.solutions;

import com.zuehlke.testing.rules.exercises.LogWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class LogWriterTest {

    private final LogWriter testee = new LogWriter();

    @Test
    void log(@TempDir Path tempDir) throws IOException {
        // arrange
        Path filePath = tempDir.resolve("logFile.txt");
        File logFile = new File(filePath.toUri());
        // act
        testee.log(logFile, "Hello Log");
        // assert
        String result = Files.readString(logFile.toPath());
        assertThat(result).contains("Hello Log");
    }
}
