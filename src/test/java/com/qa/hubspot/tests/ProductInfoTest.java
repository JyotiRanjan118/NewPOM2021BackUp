package com.qa.hubspot.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.ProductinfoPage;

public class ProductInfoTest extends BaseTest {
	
	@BeforeClass
	public void productInfoSetup() {
		accountPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void ProductInfoPageTitleTest_iMac() {
		accountPage.doSearch("iMac");
		productInfoPage=accountPage.selectProductFromResults("iMac");
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("iMac"), "iMac");
	}
	
	@Test(enabled = false)
	public void verifyProductInfoTest_Apple() throws InterruptedException  {
			String productName="Macbook";
			
			Assert.assertTrue(accountPage.doSearch(productName));
			productInfoPage=accountPage.selectProductFromResults("MacBook Pro");
			
			
			Assert.assertTrue(productInfoPage.getProductImages() == 4);
			Map<String, String> productInfomap=productInfoPage.getProductInformation();
			System.out.println(productInfomap);
			
			Assert.assertEquals(productInfomap.get("name"), "MacBook Pro");
			
	}
	
	@Test(priority = 2)
	public void verifyProductInfoTest_iMac() throws InterruptedException  {
			String productName="iMac";
			Assert.assertTrue(accountPage.doSearch(productName));
			
			productInfoPage=accountPage.selectProductFromResults("iMac");
			
			Assert.assertTrue(productInfoPage.getProductImages() == 3);
			Map<String, String> productInfomap=productInfoPage.getProductInformation();
			System.out.println(productInfomap);
			
			Assert.assertEquals(productInfomap.get("name"), "iMac");
			
	}
	
	
}
