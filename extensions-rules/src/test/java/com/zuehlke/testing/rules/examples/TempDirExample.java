package com.zuehlke.testing.rules.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class TempDirExample {

    @Test
    void testWithTemporaryDirectory(@TempDir Path tempDir) throws IOException {
        // arrange
        Path filePath = tempDir.resolve("logFile.txt");
        File logFile = new File(filePath.toUri());
        logFile.createNewFile();

        //assert
        assertThat(logFile.canRead(), equalTo(true));
    }
}
