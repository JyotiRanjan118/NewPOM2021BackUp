package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.hubspot.pages.AccountPage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.ProductinfoPage;
import com.qa.hubspot.pages.RegisterPage;

public class BaseTest {
		
		public BasePage basepage;
		public LoginPage loginPage;
		public AccountPage accountPage;
		public ProductinfoPage productInfoPage;
		public RegisterPage registerpage;
		
		public Properties prop;
		public WebDriver driver;
		
		@BeforeTest
		public void setup() {
			basepage=new BasePage();
			prop=basepage.init_prop();
			String browser=prop.getProperty("browser");
			driver = basepage.init_driver(browser);
			loginPage=new LoginPage(driver);
			driver.get(prop.getProperty("url"));
			
		}
		
		@AfterTest
		public void tearDown() {
			driver.quit();
			
		}
	
}
