package com.selenium.POM.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getUrl(String url) {
	  driver.get(url);
	}

}
