package org.amazon.example.testcases;

import org.amazon.example.base.Helper;
import org.amazon.example.pages.AppMainPage;
import org.amazon.example.pages.CartPage;
import org.amazon.example.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.amazon.example.utils.Listeners.class)
public class TestCaseSample extends Helper {
	static AppMainPage mainpage;
	static SignUpPage signuppage;
	static CartPage cartpage;

	@Test(description = "Checks whether skip button is present at the start", enabled = true)
	public static void skipbuttonValidation() throws Exception {
		signuppage = new SignUpPage(driver);
		mainpage = new AppMainPage(driver);
		cartpage = new CartPage(driver);

		signuppage.signUpSkip();
		signuppage.signUpSkipValidation();

	}



}
