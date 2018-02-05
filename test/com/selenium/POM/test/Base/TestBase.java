package com.selenium.POM.test.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.selenium.POM.Pages.LoginPage;
import com.selenium.POM.common.CookiesUtil;

public class TestBase  {
	public WebDriver driver;
	
	
	@BeforeMethod
	public void init(){
		initDriver("Chrome");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	
	@AfterMethod
	public void release() {
		//driver.quit();
	}
	
	protected String loginAsDefaultUser() {
		 LoginPage lp = new LoginPage(driver).open();
		 lp.doLogin("kapase_deepa@yahoo.co.in", "deepa4198");
		 CookiesUtil.storeCookies(driver);
		 return driver.getTitle();
	}
	
	
	
	public void initDriver(String browserName){
		
		if(browserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			 driver=new ChromeDriver();
		
		}
	}
}
