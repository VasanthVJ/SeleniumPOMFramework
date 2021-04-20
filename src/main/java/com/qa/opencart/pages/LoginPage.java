package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;
import com.qa.opencart.util.ElementUtility;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtility elementUtil; // reference for Element util
	
	private By userName = By.id("input-email");
	private By passwword = By.id("input-password");
	private By loginButton = By.xpath("//input[@type='submit']");
	private By forgotPassword = By.cssSelector("div.form-group a");
	
	//constructors
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtility(driver); // object created to access all the methods inside element util.
		
	}
	
	public String getLoginPageTitle() {
		//return elementUtil.waitForTitle(5, Constants.LOGIN_PAGE_TITLE);
		return elementUtil.getTitle();
	}
	
	public String getLoginPageUrl() {
		return elementUtil.getCurrentURL();
	}
	
	public boolean isForgotPwdLinkExist() {	
		return driver.findElement(forgotPassword).isDisplayed();	
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(userName, un);
		elementUtil.doSendKeys(passwword, pwd);
		elementUtil.doClick(loginButton);
		
		return new AccountsPage(driver);	
	}
	

}
