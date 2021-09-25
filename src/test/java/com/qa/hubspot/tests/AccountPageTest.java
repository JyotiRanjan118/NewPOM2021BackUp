package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC-200: Design Accounts Page")
@Story("US - 201: desiging the accounts page with title, header, account sections and product results..")
public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void AccountsPageSetUp() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Description("account page title test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void accountsPageTitleTest() {
		String title = accountPage.getAccountPagetitle();
		System.out.println("accounts page title is : " + title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Description("accounts page header test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void verifyAccountsPageHeaderTest() {
		String headerValue = accountPage.getHeaderValue();
		System.out.println("accounts page header is : " + headerValue);
		Assert.assertEquals(headerValue, Constants.ACCOUNTS_PAGE_HEADER);
	}
	
	@Description("account Page sections count test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void verifyMyAccountSectionsCountTest() {
		Assert.assertTrue(accountPage.getAccountSectionsCount()==Constants.ACCOUNTS_SECTIONS);
	}
	
	@Description("accunts page sections list test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void verifyMyAccountSectionsListTest() {
		Assert.assertEquals(accountPage.getAccountSectionsList(), Constants.getAccountSectionList());
	}
	
	@Description("account page search Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 5)
	public void searchTest() {
		Assert.assertTrue(accountPage.doSearch("iMac"));
	}
	
}
