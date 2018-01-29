package com.selenium.POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.POM.Base.BasePage;

public class ProductDetailsPage extends BasePage {

	private static final String ADD_TO_CART = "//*[@id='add-to-cart-button']";
	
	@FindBy(xpath=ADD_TO_CART)
	private WebElement addToCartButton;
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public AddedToCartConfirmationPage addToCart() {
		addToCartButton.click();
		return new AddedToCartConfirmationPage(driver);
	}
	

}
