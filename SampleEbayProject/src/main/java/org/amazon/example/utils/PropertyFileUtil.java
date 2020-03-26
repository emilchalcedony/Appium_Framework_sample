package org.amazon.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.amazon.example.base.Helper;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertyFileUtil extends Helper {

	public static String propertyFileRead(String propertyFileData) throws IOException, InterruptedException {
		file = new File(root + "\\Configuration\\config.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		properties = new Properties();

		// load properties file
		try {
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String data = properties.getProperty(propertyFileData);
		return data;

	}

	public static void propertyFileWrite(String setKey, String setValue) throws IOException {

		try {
			propertiesconfig = new PropertiesConfiguration(propertyFilePath);
			propertiesconfig.setProperty(setKey, setValue);

			propertiesconfig.save();

		} catch (ConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}

}
