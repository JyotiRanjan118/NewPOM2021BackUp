package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.testlistener.ExtentReportListener;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;


public class LoginPage extends BasePage {
		
		private WebDriver driver;
		private ElementUtil elementUtil;
	
		//1.By Locators : OR
		private By emailID=By.id("input-email");
		private By password=By.id("input-password");
		private By loginButton = By.xpath("//input[@value='Login' and @type='submit']");
		private By forgotPwdLink=By.linkText("Forgotten Password123");
		private By registerLink = By.linkText("Continue");
		
		//2.Constructor of the page class
		
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			elementUtil=new ElementUtil(this.driver);
		}
		
		//3.page actions: features of the page in the form methods
		
		@Step("gettting the login page title.....")
		public String getLoginPageTitle() {
				return elementUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, 10);
		}
		
		@Step("checking forgot pwd link is exist.....")
		public boolean isForgotPwdLinkExist() {
			return elementUtil.doIsDisplayed(forgotPwdLink);
		}
		
		@Step("login with username : {0} and password : {1}")
		public AccountPage doLogin(String un,String pwd) {
				System.out.println("Login with : "+un+" and "+pwd);
				elementUtil.doSendKeys(emailID, un);
				elementUtil.doSendKeys(password, pwd);
				elementUtil.doClick(loginButton);
				
				return new AccountPage(driver);
				
		}
		
		@Step("navigating to the register page....")
		public RegisterPage navigateToRegisterPage() {
			elementUtil.doClick(registerLink);
			return new RegisterPage(driver);
		}
		
}
