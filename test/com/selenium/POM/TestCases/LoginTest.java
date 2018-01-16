package com.selenium.POM.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.selenium.POM.Pages.HomePage;
import com.selenium.POM.Pages.LaunchPage;
import com.selenium.POM.Pages.LoginPage;
import com.selenium.POM.Pages.ProfilePage;
import com.selenium.POM.test.Base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void doLogin() {
		init("Firefox");
		driver.get("http:www.facebook.com");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.doLogin("deepakapase@gmail.com", "deepa4198");

	}

	@Test(dependsOnMethods = { "doLogin" })
	public void findFriend() {
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.gotoProfile();
		ProfilePage pp=PageFactory.initElements(driver, ProfilePage.class);
		pp.searchFriend();
	}
}
