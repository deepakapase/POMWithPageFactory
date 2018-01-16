package com.selenium.POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.POM.Base.BasePage;
import com.selenium.POM.Util.POMConstatns;

public class HomePage extends BasePage{
	
	@FindBy(xpath=POMConstatns.PROFILEPAGELINK)
	public WebElement profileLink;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public ProfilePage gotoProfile(){
		profileLink.click();
		return PageFactory.initElements(driver, ProfilePage.class);
	}

}
