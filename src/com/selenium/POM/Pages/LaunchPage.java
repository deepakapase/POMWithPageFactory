package com.selenium.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.POM.Base.BasePage;

public class LaunchPage extends BasePage {
	
	public LaunchPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath=".//*[@id='signin_info']/a[1]")
	public WebElement loginLink;


	public LoginPage gotoLogin() {
		loginLink.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
}
