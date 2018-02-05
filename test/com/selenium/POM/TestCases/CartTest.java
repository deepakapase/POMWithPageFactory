package com.selenium.POM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.POM.Pages.CartPage;
import com.selenium.POM.Pages.HomePage;
import com.selenium.POM.Pages.ProductDetailsPage;
import com.selenium.POM.test.Base.TestBase;

public class CartTest extends TestBase {

	@Test
	public void testAddToCardAndCheckOut() {
		loginAsDefaultUser();
		HomePage hp = new HomePage(driver);
		hp.open();
		ProductDetailsPage pdp = hp.search("diapers").selectFirstProduct();
		String proTitle = pdp.getProductTitle();
		float proPrice = pdp.getPriceOfProduct();
		int proQuantity = pdp.getSelectedQuantity();
		
		pdp.addToCart();
		CartPage cp = hp.openCart();
		Assert.assertNotNull(cp.findProductInCart(proTitle));
		Assert.assertEquals(cp.getProductPrice(proTitle), proPrice);
		Assert.assertEquals(cp.getQuantity(proTitle), proQuantity);
		
		
		


	}

	//@Test
	public void testRemoveFromCart() {
		loginAsDefaultUser();
		HomePage hp = new HomePage(driver);

		CartPage cp = hp.openCart();
		int currentSize = cp.size();
		String pName = cp.getRandomProductName();
		int quantity=cp.getQuantity(pName);

		float price = cp.getProductPrice(pName);
		float total = cp.getCartTotalPrice();
		float expected = total - (price * quantity);

		cp.deleteCartItem(pName);

		hp.openCart();
		Assert.assertEquals(cp.size(), currentSize - 1);
		Assert.assertEquals(cp.getCartTotalPrice(), Math.round(expected*100.0f)/100.0f);
	}
	
	//@Test
	public void testRemoveFromCartWithName(){
		loginAsDefaultUser();
		HomePage hp = new HomePage(driver);

		CartPage cp = hp.openCart();
		int currentSize = cp.size();
		String pName = cp.getRandomProductName();
		cp.deleteCartItem(pName);
		hp.openCart();
		Assert.assertEquals(cp.size(), currentSize - 1);
	}
	
	//@Test
	public void testQuantity(){
		loginAsDefaultUser();
		HomePage hp = new HomePage(driver);
		CartPage cp = hp.openCart();
		int quatityChange = 2;
		String pName = cp.getRandomProductName();
		/* get data for assertion */
		float price = cp.getProductPrice(pName);
		float total = cp.getCartTotalPrice();
		System.out.println("prduct name: " + pName +"product price : "+price);
		cp.changeProductQuantity(pName, quatityChange);
		hp.openCart();
		Assert.assertEquals(cp.getCartTotalPrice(), total + price * quatityChange);
	}

}
