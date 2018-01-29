package com.selenium.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.POM.Base.BasePage;
import com.selenium.POM.Util.POMConstatns;

public class LoginPage extends BasePage {

  public static final String USERNAME = ".//*[@id='ap_email']";
  public static final String PASSWORD = ".//*[@id='ap_password']";
  public static final String LOGIN = ".//*[@id='signInSubmit']";

	@FindBy(xpath = USERNAME)
	public WebElement userName;
	@FindBy(xpath = PASSWORD)
	public WebElement password;
	@FindBy(xpath = LOGIN)
	public WebElement login;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage open() {
	  getUrl(POMConstatns.LOGIN_URL);
	  return this;
	}

	public HomePage doLogin(String uName,String pass){
		userName.sendKeys(uName);
		password.sendKeys(pass);
		login.click();
		return new HomePage(driver);
	}
}
