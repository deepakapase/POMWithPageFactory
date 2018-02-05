package com.selenium.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.selenium.POM.Base.BasePage;

public class ProductDetailsPage extends BasePage {

	private static final String ADD_TO_CART = "//*[@id='add-to-cart-button']";
	public static final String PRODUCT_TITLE = "//span[@id='productTitle'] ";
	private static final String PRICE_PRODUCT = "//span[@id='priceblock_ourprice']";
	private static final String QUANTITY = "//select[@id='quantity']";
	
	@FindBy(xpath=ADD_TO_CART)
	private WebElement addToCartButton;
	
	@FindBy (xpath = PRODUCT_TITLE)
	private WebElement productTitle;
	
	@FindBy (xpath = PRICE_PRODUCT)
	private WebElement productPrice;

	@FindBy (xpath =  QUANTITY)
	private WebElement productQuantity;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public String getProductTitle(){
		return  productTitle.getText();
	}
	
	public float getPriceOfProduct(){
		String str=productPrice.getText();
		String price=str.substring(1).trim();
		float endPrice=Float.parseFloat(price);
		return endPrice;
	}
	
	public int getSelectedQuantity(){
		Select select=new Select(productQuantity);
		String quantity = select.getFirstSelectedOption().getText().trim();
		int endQuantity=Integer.parseInt(quantity);
		return endQuantity;
	}
	
	public AddedToCartConfirmationPage addToCart() {
		addToCartButton.click();
		return new AddedToCartConfirmationPage(driver);
	}
	

}
