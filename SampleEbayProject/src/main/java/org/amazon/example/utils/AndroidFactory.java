package org.amazon.example.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.amazon.example.base.Helper;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AndroidFactory extends Helper {
	@SuppressWarnings("rawtypes")
	public static void AppSetUp() throws IOException, InterruptedException {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/apkFiles/");
		File app = new File(appDir, PropertyFileUtil.propertyFileRead("appname"));
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("appPackage", PropertyFileUtil.propertyFileRead("appPackage"));
		capabilities.setCapability("appActivity", PropertyFileUtil.propertyFileRead("appActivity"));
		capabilities.setCapability("deviceOrientation", PropertyFileUtil.propertyFileRead("orientation"));
		capabilities.setCapability("deviceName", PropertyFileUtil.propertyFileRead("deviceName"));
		capabilities.setCapability("platformVersion", PropertyFileUtil.propertyFileRead("platformVersion"));
		capabilities.setCapability("locationServicesAuthorized", true);
		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());


		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}
}
