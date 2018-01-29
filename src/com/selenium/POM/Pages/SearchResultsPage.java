package com.selenium.POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.POM.Base.BasePage;

public class SearchResultsPage extends BasePage {

	private static final String FIRST_PRODUCT = "//*[@id='result_0']/div/div/div/div[1]/div/div/a/img";
	
	@FindBy(xpath=FIRST_PRODUCT)
	private WebElement firstProduct;
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailsPage selectFirstProduct() {
		firstProduct.click();
		return new ProductDetailsPage(driver);
	}
	

}
