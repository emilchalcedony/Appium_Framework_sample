package org.amazon.example.pages;

import org.amazon.example.base.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentsPage extends Helper {

	public PaymentsPage(@SuppressWarnings("rawtypes") AndroidDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	WebElement searchTextBox;

	public void productSearch() throws Exception {
		click(searchTextBox);
		sendKeys(searchTextBox, "");

	}

}
