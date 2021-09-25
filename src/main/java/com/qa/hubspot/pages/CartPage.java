package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class CartPage extends BasePage {
	
	private WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void addToCart() {
		System.out.println("Item is added to cart");
	}
	
}
