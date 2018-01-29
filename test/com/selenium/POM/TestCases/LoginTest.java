package com.selenium.POM.TestCases;

import org.testng.annotations.Test;

import com.selenium.POM.Pages.LoginPage;
import com.selenium.POM.test.Base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void doLogin() {
		//init("Firefox");
		LoginPage lp = new LoginPage(driver);
		lp.open();
		lp.doLogin("kapase_deepa@yahoo.co.in", "deepa4198");
	}


}
