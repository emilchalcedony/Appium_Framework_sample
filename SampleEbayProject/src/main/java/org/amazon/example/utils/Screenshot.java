package org.amazon.example.utils;

import java.io.File;

import org.amazon.example.base.Helper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot extends Helper {

	public static String createScreenshotDir(String testcaseName) {

		File file = new File(root + "/Screenshots/" + testcaseName + "/");
		if (file.isDirectory()) {

			File[] images = file.listFiles();
			for (File oldImage : images) {
				oldImage.delete();

			}
			file.delete();

		}

		if (!testcaseName.equals("Default test")) {
			file.mkdir();
		}

		return testcaseName;
	}

	public static String takeScreenshot(WebDriver driver) throws Exception {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = null;
		try {

			dest = new File("Screenshots/" + testcaseName + "/" + System.currentTimeMillis() + ".png");
			FileUtils.copyFile(src, dest);

		}

		catch (Exception e) {

			logger.info(e);

			throw e;

		}
		String path = dest.getAbsolutePath();
		return path;

	}

}
