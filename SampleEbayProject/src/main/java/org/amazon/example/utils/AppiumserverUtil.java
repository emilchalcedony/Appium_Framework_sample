package org.amazon.example.utils;

import java.io.IOException;

import org.amazon.example.base.Helper;

public class AppiumserverUtil extends Helper {
	public static Process process;
	

	public static void startServer() throws IOException, InterruptedException {
		String STARTSERVER = null;
		STARTSERVER = "C:\\Program Files\\Appium\\Appium.exe C:\\Program Files\\nodejs\\node.exe";
		Runtime runtime = Runtime.getRuntime();
		process = runtime.exec(STARTSERVER);
		Thread.sleep(5000);

		if (process != null) {

			logger.info("Appium server is started");
		}
	}

	public static void stopServer() throws IOException, InterruptedException {

		if (process != null) {
			process.destroy();

		}

		logger.info("Appium server is stoped");

	}
}
