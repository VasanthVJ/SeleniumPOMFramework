package com.qa.opencart.pages;

import java.util.List;
import java.util.concurrent.locks.Condition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtility;

public class AccountsPage {
	
	private ElementUtility elementUtil ;
	private WebDriver driver;
	
	private By accHeaders = By.xpath("//div[@id='content']/h2");
	private By header = By.cssSelector("div#logo a");
	private By logOutLink = By.linkText("Logout");
	private By searchBox = By.name("search");
	private By searchButton = By.cssSelector("div #search button");
			
	public AccountsPage(WebDriver driver) {
		this.driver = driver;		
		elementUtil = new ElementUtility(driver);
	}
	
	public String getAccPageTite() {
		return elementUtil.waitForTitle(4, Constants.ACC_PAGE_TITLE);
		
	}
	
	public String getAccPageUrl() {
		
		return elementUtil.getCurrentURL();
	}
	
	public String getAccPageHeader() {
		return elementUtil.getText(header);
	}
	
	public List<String> getAccHeaders() {
		
		return elementUtil.GetElementsTextList(accHeaders);
	}
	
	public boolean isLogoutExist() {
		
		return elementUtil.isDisplayed(logOutLink);
	}
	
	public SearchProduct doSearch(String productName) {
		System.out.println("Product name " +productName);
		elementUtil.doSendKeys(searchBox, productName);
		elementUtil.doClick(searchButton);
		return new SearchProduct(driver);
		
	}

}
