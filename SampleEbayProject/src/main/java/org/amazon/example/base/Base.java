package org.amazon.example.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.amazon.example.utils.Listeners;
import org.amazon.example.utils.Reports_Logs;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Base {

	// Declarations

	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	@SuppressWarnings("rawtypes")
	public static TouchAction touch;
	public static Logger logger;
	public static String testcaseName;
	public static ExtentTest test;
	public static ExtentReports report;
	public static File file;
	public static Properties properties;
	public static EventFiringWebDriver eventDriver;
	public static Listeners listeners;
	public static String testdataPath;
	public static String propertyFilePath;
	public static FileOutputStream fos;
	public static FileInputStream fis;
	public static PropertiesConfiguration propertiesconfig;
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell cell;
	public static XSSFRow Row;
	public static short lastcoloumnnum;
	public static int lastrownum;
	public static Object CellData;
	public static String region;
	public static int counter;
	public static String log4jpath = "Configuration//log4j.properties";
	public static String root = System.getProperty("user.dir");
	public static File app = new File(root, "/apkFiles/Amazon_shopping.apk");
	public static DesiredCapabilities capabilities;

	// driver initialization
	@BeforeTest
	public void init() throws Exception {

		Reports_Logs.InitConfigurations();
		Helper.launchApp();
		logger.info("App is launched");

		
	}

	// Lauches app before every test
	@BeforeMethod
	public void launchAndNavigate() throws IOException, Exception {
		driver.launchApp();
	}

	// closes app before every test
	@AfterMethod
	public void closeApp() throws Exception {
		driver.closeApp();
	}

	// Closes the report and removes the app from the system
	@AfterTest
	public static void tearDown() throws IOException {
		logger.info("Test Execution completed");
		report.flush();
		driver.removeApp("com.example.AppName");

	}
}
