package com.selenium.POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.POM.Base.BasePage;
import com.selenium.POM.Util.POMConstatns;

public class HomePage extends BasePage{
	
	private static final String SEARCH_TEXT_BOX = ".//*[@id='twotabsearchtextbox']";
	private static final String SEARCH_SUBMIT_BUTTON = "//*[@id='nav-search']/form/div[2]/div/input";

	@FindBy(xpath=SEARCH_TEXT_BOX)
	public WebElement searchTextBox;
	@FindBy(xpath=SEARCH_SUBMIT_BUTTON)
	public WebElement searchSubmitButton;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage open() {
	  getUrl(POMConstatns.SITE_URL);
	  return this;
	}
	
	public SearchResultsPage search(String searchText) {
		searchTextBox.sendKeys(searchText);
		searchSubmitButton.click();
		return new SearchResultsPage(driver);
	}
	
}
