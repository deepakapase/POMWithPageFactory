package com.selenium.POM.test.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase  {
	public WebDriver driver;
	public void init(String browserName){
		
		if(browserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			 driver=new FirefoxDriver();

		}
	}
}
