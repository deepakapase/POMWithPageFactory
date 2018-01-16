package com.selenium.POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.POM.Base.BasePage;
import com.selenium.POM.Util.POMConstatns;

public class ProfilePage extends BasePage{

	@FindBy(xpath=POMConstatns.FRIENDSLINK)
	public WebElement friendsList;
	@FindBy(xpath=POMConstatns.FRIENDSEARCH)
	public WebElement friendSearch;
	public ProfilePage(WebDriver driver) {
		super(driver);
		System.out.println("Profile page ");
	}
	
	public void searchFriend(){
		friendsList.click();
		friendSearch.sendKeys("Sandeep");
		System.out.println("*****************************************"+friendSearch.getText());
	}
}
