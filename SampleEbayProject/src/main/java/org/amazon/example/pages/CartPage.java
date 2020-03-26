package org.amazon.example.pages;

import org.amazon.example.base.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class CartPage extends Helper {

	@SuppressWarnings("rawtypes")
	public CartPage(AndroidDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "com.amazon.mShop.android.shopping:id/action_bar_cart")
	WebElement cartButton;

	@FindBy(xpath = "//android.view.View[@resource-id='activeCartViewForm']//android.widget.ListView//android.view.View[contains(@text,'00')]")
	WebElement productPrice;

	public void cartButton() throws Exception {
		
		click(cartButton);

	}

	public String productPrice() throws Exception {
		String price = getText(productPrice);
		
		String productPriceCart = price.substring(1, 6);
		String productPricecart = productPriceCart.replaceAll(",", "");
		 return productPricecart;

	}

}
