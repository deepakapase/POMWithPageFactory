package com.selenium.POM.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.POM.Pages.HomePage;
import com.selenium.POM.common.CookiesUtil;
import com.selenium.POM.test.Base.TestBase;

public class HomePageTest extends TestBase{

  @BeforeMethod
  public void init() {
	  super.init();
	  
  }
  
  

  @Test
  public void testAddToCardAndCheckOut1() {
	  loginAsDefaultUser();
	  HomePage homePage = new HomePage(driver);
	  homePage.open();
	  homePage.search("Estee lauder").selectFirstProduct().addToCart().proceedToCheckout();
    
  }

}
