package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {
	
	@Test(priority =1)
	public void loginPageTitleTest() {
		
		String text = login.getLoginPageTitle();
		System.out.println("Title of the page "+text);
		Assert.assertEquals(text, "Account Login");		
	}
	
	@Test(priority =2)
	public void loginPageUrlTest() {
		String pageUrl = login.getLoginPageUrl();
		System.out.println("URL of the page is " +pageUrl);
		Assert.assertTrue(pageUrl.contains("route=account/login"));	
	}
	
	@Test(priority =3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(login.isForgotPwdLinkExist());	
	}
	
	@Test(priority = 4)
	public void doLoginTest() {
		
		login.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));
		
	}

}
