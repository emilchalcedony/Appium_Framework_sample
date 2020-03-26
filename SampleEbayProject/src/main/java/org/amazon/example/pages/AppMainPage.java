package org.amazon.example.pages;

import org.amazon.example.base.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;

public class AppMainPage extends Helper {

	@SuppressWarnings("rawtypes")
	public AppMainPage(AndroidDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	WebElement searchTextBox;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/item_title' and contains(@text, 'Curved LED Backlit')]")
	WebElement searchResultProduct;

	@FindBy(id = "add-to-cart-button")
	WebElement addtocartButton;

	@FindBy(id = "com.amazon.mShop.android.shopping:id/action_bar_cart")
	WebElement cartButton;

	@FindBy(xpath = "(//android.widget.LinearLayout[2]//android.view.ViewGroup[@resource-id='com.amazon.mShop.android.shopping:id/rs_results_styled_price_v2'])[1]/android.widget.TextView")
	WebElement productPriceText;

	@SuppressWarnings("rawtypes")
	public void productSearch(String search) throws Exception {
		click(searchTextBox);
		sendKeys(searchTextBox, search);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER).withFlag(KeyEventFlag.SOFT_KEYBOARD)
				.withFlag(KeyEventFlag.KEEP_TOUCH_MODE).withFlag(KeyEventFlag.EDITOR_ACTION));
		Thread.sleep(5000);
		swipeup();
		Thread.sleep(5000);
	}

	public void productSelection() throws Exception {
		
		
		click(searchResultProduct);
		Thread.sleep(3000);
		click(cartButton);
		swipeup();
		swipeup();
		swipeup();
		swipeup();
		click(addtocartButton);
		

	}

	public String priceinsearch() throws Exception {
		String text = getText(productPriceText);
		String productPrice = text.substring(1, 6);
		productPrice = productPrice.replaceAll(",", "");
		return productPrice;

	}

}
