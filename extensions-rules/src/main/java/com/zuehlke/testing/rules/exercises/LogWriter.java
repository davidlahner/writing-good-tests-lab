package com.zuehlke.testing.rules.exercises;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {

	public void log(File logFile, String message) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile))) {
			writer.write(message);
		}
	}
}
