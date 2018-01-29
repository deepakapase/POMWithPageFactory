package com.selenium.POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.POM.Base.BasePage;

public class AddedToCartConfirmationPage extends BasePage {

	private static final String PROCEED_TO_CHECKOUT = "//*[@id='hlb-ptc-btn-native']";
	
	@FindBy(xpath=PROCEED_TO_CHECKOUT)
	private WebElement proceedToCheckoutButton;
	
	public AddedToCartConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public void proceedToCheckout() {
		proceedToCheckoutButton.click();
	}
	

}
