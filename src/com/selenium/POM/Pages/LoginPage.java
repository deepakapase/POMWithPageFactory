package com.selenium.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.POM.Base.BasePage;
import com.selenium.POM.Util.POMConstatns;

public class LoginPage extends BasePage {
//	WebDriver driver;
//	By uName=By.xpath(".//*[@id='login1']");
//	By password=By.xpath(".//*[@id='password']");
//	By login=By.xpath("//input[@name='proceed']");
	@FindBy(xpath=POMConstatns.USERNAME)
	public WebElement userName;
	@FindBy(xpath=POMConstatns.PASSWORD)
	public WebElement password;
	@FindBy(xpath=POMConstatns.LOGIN)
	public WebElement login;

	public LoginPage(WebDriver driver) {
		
		super(driver);
	}
	public HomePage doLogin(String uName,String pass){
		System.out.println("username"+uName);
		System.out.println(userName.getTagName());
		userName.sendKeys(uName);
		password.sendKeys(pass);
		login.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
}
