package org.amazon.example.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.amazon.example.utils.AndroidFactory;
import org.amazon.example.utils.Screenshot;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Helper extends Base {

	// ******************************************************************************************
	/*
	 * Method-1 Description- Clicks on the element Parameter passed- WebElement
	 * Return type- void
	 */
	// ******************************************************************************************
	public static void click(WebElement element) throws Exception {

		try {
			element.click();
			logger.info("clicked on element" + element);
			test.log(LogStatus.INFO, "clicked on the element");

		} catch (Exception e) {

			for (int i = 0; i <= 5; i++) {
				try {
					Thread.sleep(3000);
					element.click();
					logger.info("Cliced on" + element);
					break;
				} catch (Exception exception) {
					logger.info("Unable to click on element. trying to click again");
					if (i == 5) {
						throw exception;

					}
				}
			}

		}

	}

// ******************************************************************************************
	/*
	 * Method-2 Description- Launches the .apk file with desired capabilities from
	 * property file NA Return type- WebDriver
	 */
	// ******************************************************************************************
	public static WebDriver launchApp() throws Exception {

		try {
			AndroidFactory.AppSetUp();
			logger.info("application started in device");
		} catch (Exception e) {
			throw e;
		}

		return driver;

	}

	// ******************************************************************************************

	/*
	 * Method-3 Description- Swipe down in the application Parameter passed- NA
	 * Return type- void
	 */
	// ******************************************************************************************
	@SuppressWarnings("rawtypes")
	public static void swipeDown() throws Exception {
		try {

			Dimension size = driver.manage().window().getSize();
			int startx = size.getWidth() * 1 / 2;
			int endx = size.getWidth() * 1 / 2;
			int starty = size.getHeight() * 1 / 4;
			int endy = size.getHeight() * 3 / 4;

			touch = new TouchAction(driver);
			touch.press(PointOption.point(startx, starty))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
					.moveTo(PointOption.point(endx, endy)).release().perform();

			logger.info("swiped down");
		} catch (Exception e) {
			throw e;
		}

	}

	// ******************************************************************************************

	/*
	 * Method-4 Description- Swipe up in the application Parameter passed- NA Return
	 * type- void
	 */
	// ******************************************************************************************
	@SuppressWarnings("rawtypes")
	public static void swipeup() throws Exception {
		try {

			Dimension size = driver.manage().window().getSize();
			int startx = size.getWidth() * 1 / 2;
			int endx = size.getWidth() * 1 / 2;
			int starty = size.getHeight() * 3 / 4;
			int endy = size.getHeight() * 1 / 2;

			touch = new TouchAction(driver);
			touch.press(PointOption.point(startx, starty))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
					.moveTo(PointOption.point(endx, endy)).release().perform();
			Thread.sleep(2000);
			logger.info("swiped up");
		} catch (Exception e) {
			throw e;
		}

	}

	// ******************************************************************************************

	/*
	 * Method-5 Description- Swipe right in the application Parameter passed- NA
	 * Return type- void
	 */
	// ******************************************************************************************
	@SuppressWarnings("rawtypes")
	public static void swiperight() throws Exception {
		try {

			Dimension size = driver.manage().window().getSize();
			int startx = size.getWidth() * 1 / 4;
			int endx = size.getWidth() * 1 / 2;
			int starty = size.getHeight() * 1 / 2;
			int endy = size.getHeight() * 1 / 2;

			touch = new TouchAction(driver);
			touch.press(PointOption.point(startx, starty))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
					.moveTo(PointOption.point(endx, endy)).release().perform();
			Thread.sleep(2000);
			logger.info("swiped up");
		} catch (Exception e) {
			throw e;
		}

	}

	// ******************************************************************************************

	/*
	 * Method-6 Description- Swipe left in the application Parameter passed- NA
	 * Return type- void
	 */
	// ******************************************************************************************
	@SuppressWarnings("rawtypes")
	public static void wipeleft() throws Exception {
		try {

			Dimension size = driver.manage().window().getSize();
			int startx = size.getWidth() * 3 / 4;
			int endx = size.getWidth() * 1 / 2;
			int starty = size.getHeight() * 1 / 2;
			int endy = size.getHeight() * 1 / 2;

			touch = new TouchAction(driver);
			touch.press(PointOption.point(startx, starty))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
					.moveTo(PointOption.point(endx, endy)).release().perform();
			Thread.sleep(2000);
			logger.info("swiped up");
		} catch (Exception e) {
			throw e;
		}

	}

	// ******************************************************************************************

	/*
	 * Method-7 Description- double taps on the element Parameter passed- WebElement
	 * Return type- void
	 */
	// ******************************************************************************************
	public static void doubleTap(WebElement element) {
		try {
			TouchActions action = new TouchActions(driver);
			action.doubleTap(element);
			action.perform();
			logger.info("Double tapped on element" + element);
		} catch (Exception e) {
			logger.info("failed to double tap" + e);
			throw e;

		}

	}

	// ******************************************************************************************
	/*
	 * Method-8 Description- Returns timestamp in the format "ddMMyyyyHHmmss"
	 * Parameter passed- NA example- 04012020120466 Return type- String
	 */
	// ******************************************************************************************
	public static String GetTimeStamp() {
		DateFormat DF = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date dte = new Date();
		String DateValue = DF.format(dte);

		return DateValue;

	}

	// ******************************************************************************************

	/*
	 * Method-9 Description- String parameters to be passed in the application
	 * Parameter passed- WebElement, String Return type- void
	 */
	// ******************************************************************************************
	public static void sendKeys(WebElement element, String sendkeys) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(sendkeys);
		} catch (Exception e) {
			throw e;
		}
	}

	// ******************************************************************************************
	/*
	 * Method-10 Description- Keys parameters to be passed in the application
	 * Parameter passed- WebElement, Keys Return type- void
	 */
	// ******************************************************************************************
	public static void sendKeys(WebElement element, Keys sendkeys) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(sendkeys);
			logger.info(sendkeys + "is entered");
		} catch (Exception e) {
			throw e;
		}
	}

	// ******************************************************************************************

	/*
	 * Method-11 Description- checks whether element is displayed Parameter passed-
	 * WebElement Return type- void
	 */
	// ******************************************************************************************
	public static boolean isDisplayed(WebElement element) throws Exception {

		try {
			element.isDisplayed();
			logger.info(element + " is displayed");
			test.log(LogStatus.INFO,
					element + "is displayed" + test.addScreenCapture(Screenshot.takeScreenshot(driver)));

			return true;
		} catch (Exception e) {
			logger.info("Element is not displayed");

			return false;
		}

	}

	// ******************************************************************************************

	/*
	 * Method-12 Description- checks whether element is selected Parameter passed-
	 * WebElement Return type- void
	 */
	// ******************************************************************************************
	public static boolean isSelected(WebElement element) {

		try {
			element.isSelected();
			logger.info("Element is selected");
			return true;
		} catch (Exception e) {
			logger.info("Element is not selected");

			return false;
		}

	}
	// ******************************************************************************************

	/*
	 * Method-13 Description- checks whether element is enabled Parameter passed-
	 * WebElement Return type- boolean
	 */
	// ******************************************************************************************
	public static boolean isEnabled(WebElement element) {

		try {
			element.isEnabled();
			logger.info("Element is enabled");

			return true;
		} catch (Exception e) {
			logger.info("Element is not enabled");
			return false;

		}
	}
	// ******************************************************************************************

	/*
	 * Method-14 Description- checks for an expected string with the string from the
	 * application Parameter passed- WebElement, String Return type- void
	 */
	// ******************************************************************************************
	public static void assertValues(WebElement element, String expected) {

		String actual = getText(element);
		try {
			Assert.assertEquals(actual, expected);
			logger.info("Actual and expected values are matching");
		} catch (Exception e) {
			logger.info("Actual and expected values are not matching");
			throw e;

		}
	}

	// ******************************************************************************************
	/*
	 * Method-15 Description- Returns a string from the application Parameter
	 * passed- WebElement Return type- String
	 */
	// ******************************************************************************************
	public static String getText(WebElement element) {
		String text = null;
		try {
			text = element.getText();
			logger.info(" text  fetched from the app is:" + text);
		} catch (Exception e)

		{
			throw e;
		}
		return text;

	}
	// ******************************************************************************************

}
