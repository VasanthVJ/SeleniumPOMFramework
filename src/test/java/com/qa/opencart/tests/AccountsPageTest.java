package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.util.Constants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void loginSetup() {
		
		accPage = login.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));		
	}
	
	@Test(priority =1)
	public void accPageTitleTest() {
		String title = accPage.getAccPageTite();
		System.out.println("Title of the page : " +title);
		Assert.assertEquals(title, Constants.ACC_PAGE_TITLE);
		
	}
	
	@Test(priority =2)
	public void accPageUrlTest() {
		String pageURL = accPage.getAccPageUrl();
		System.out.println("Account page Url: " +pageURL);
		Assert.assertTrue(pageURL.contains("route=account/account"));
	}
	
	@Test(priority =3)
	public void accPageHeaderTest() {
		
		List<String> headers = accPage.getAccHeaders();
		
		for(String e: headers) {
			
			System.out.println("Header Are " +e);
		}
	}
	
	@Test(priority =4)
	public void logOutLinkTest() {
		
		Boolean logoutLink =accPage.isLogoutExist();
		Assert.assertTrue(logoutLink.TRUE);
	}
	

}
