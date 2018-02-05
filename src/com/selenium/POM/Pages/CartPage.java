package com.selenium.POM.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.selenium.POM.Base.BasePage;

public class CartPage extends BasePage {
	private static final String XPATH_CART_ITEMS = "//div[@class='a-row sc-list-item sc-list-item-border sc-java-remote-feature']";
	private static final String deleteProduct = "//input[@value='Delete']";
	private static final String productName= "//span[@class='a-size-medium sc-product-title a-text-bold']";
	private static final String productquantity="quantity";
	private static final String price="//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold']";
	private static final String total="//span[@id='sc-subtotal-amount-activecart']";

	@FindBy(xpath = XPATH_CART_ITEMS)
	private List<WebElement> cartList;
	
	@FindBy(xpath =total)
	private WebElement subTotal;
	
	
	public CartPage(WebDriver driver) {
		super(driver);
	}

	public int size() {
		return cartList.size();
	}
	public void deleteCartItem(String productName) {
		WebElement elementToBeDeleted = findProductInCart(productName);
		if(elementToBeDeleted == null){
			return ;
		}
		elementToBeDeleted.findElement(By.xpath(deleteProduct)).click();
	}
	
	

	public void deleteCartItem(int index) {
		WebElement elementToBeDeleted = cartList.get(index);
		elementToBeDeleted.findElement(By.xpath(deleteProduct)).click();
	}
	
	public void clearCart() {
		for (WebElement item : cartList) {
			item.findElement(By.xpath(deleteProduct)).click();

		}
	}
	public WebElement findProductInCart(String name){
		if(name == null || name.isEmpty()) {
			return null;
		}
		for(WebElement product : cartList) {
			String temp = product.findElement(By.xpath(productName)).getText();
			if(name.equalsIgnoreCase(temp)) {
				return product;
			}
		}
		return null;
	}
	
	public String getRandomProductName() {
		Random random = new Random();
		int index = random.nextInt(100);
		WebElement randomElement = cartList.get(index%cartList.size());
		return randomElement.findElement(By.xpath(productName)).getText();
	}
	
	public void changeProductQuantity(String productName,int qc){
		WebElement elementToBeUpdated = findProductInCart(productName);

		Select select=new Select(elementToBeUpdated.findElement(By.name(productquantity)));
		int quantity = Integer.parseInt(select.getFirstSelectedOption().getText().trim());
		select.selectByValue(Integer.toString(quantity+qc));
		
	}
	
	public int getQuantity(String pname){
		WebElement elementToBeUpdated = findProductInCart(pname);

		Select select=new Select(elementToBeUpdated.findElement(By.name(productquantity)));
		int quantity = Integer.parseInt(select.getFirstSelectedOption().getText().trim());
		return quantity;
		
	}
	public float getProductPrice(String productName) {
		WebElement product = findProductInCart(productName);
		WebElement price_of_product=product.findElement(By.xpath(price));
		String str = price_of_product.getText();
		
		float price = Float.parseFloat(str.substring(1, str.length()));
		return price;
	}
	
	public float getCartTotalPrice() {
		
		String str = subTotal.getText();
		
		float totalAmonut = Float.parseFloat(str.substring(1, str.length()));
		return totalAmonut;
	}

}
