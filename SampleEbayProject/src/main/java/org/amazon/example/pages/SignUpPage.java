package org.amazon.example.pages;

import org.amazon.example.base.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class SignUpPage extends Helper {

	public SignUpPage(@SuppressWarnings("rawtypes") AndroidDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	WebElement signUpButton;

	public void signUpSkip() throws Exception {
		click(signUpButton);

	}

	public void signUpSkipValidation() throws Exception {
		Boolean displayed = isDisplayed(signUpButton);
		if (displayed) {
			
			logger.info("element is displayed");
			Assert.assertTrue(true);

		} else {
			logger.info("element is not displayed");
			Assert.assertTrue(false);

		}

	}

}
