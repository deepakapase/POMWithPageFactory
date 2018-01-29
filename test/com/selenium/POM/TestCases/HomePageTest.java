package com.selenium.POM.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.POM.Pages.HomePage;
import com.selenium.POM.Pages.LoginPage;
import com.selenium.POM.test.Base.TestBase;

public class HomePageTest extends TestBase{

  @BeforeMethod
  public void init() {
	  
  }
  
  @Test
  public void testAddToCardAndCheckOut() {
	  loginAsDefaultUser();
	  HomePage homePage = new HomePage(driver);
	  homePage.open();
	  homePage.search("diapers").selectFirstProduct().addToCart().proceedToCheckout();
    
  }
  
}
