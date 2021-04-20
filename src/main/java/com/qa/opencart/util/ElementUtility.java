package com.qa.opencart.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Text;

public class ElementUtility {
	
	WebDriver driver;
	
	public ElementUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElemet(By id) {
		return driver.findElement(id);
	}
	
	public  List<WebElement> getElements(By id) {
		return driver.findElements(id);
	}
	
	public List<String> GetElementsTextList(By id) {
		
		List<String> eleTextList = new ArrayList<String>();
		
		List<WebElement> eleList = getElements(id);
		for(WebElement e : eleList) {
			
			if(!e.getText().isEmpty()) {
				
				eleTextList.add(e.getText());
			}
					
		}
		return eleTextList;
		
	}
	
	public String getText(By id) {
		return getElemet(id).getText();
		
	}
	
	public boolean isDisplayed(By id) {
		
		return getElemet(id).isDisplayed();		
	}
	
	
	public String getTitle() {
		return driver.getTitle();
		
	}
	
	public String getCurrentURL() {
		
		return driver.getCurrentUrl();	
	}
	
	public void doSendKeys(By id, String value) {
		WebElement element = getElemet(id);
		element.clear();
		element.sendKeys(value);
	}
	
	public void switchToWindow(String windowId) {
		
		driver.switchTo().window(windowId);
		String text = driver.getTitle();
		System.out.println(text);
	}
	
	public void doClick(By id) {
		getElemet(id).click();	
	}
	
	public List<String> doGetAttribute(By locator, String attriName) {
		
		List<String> attrList = new ArrayList<String>();
		List<WebElement> listOfElement = getElements(locator);
		for(WebElement e : listOfElement) {
			attrList.add(e.getAttribute(attriName));	
		}
		return attrList;
	}
	
	
	/*
	 * to get window handles
	 */
	public Set<String> getWindowHandles() {
		
		Set<String> WinHandles = driver.getWindowHandles();	
		return WinHandles;
	}
	
	
	public void switchWindow(Set<String> windowHandle) {
		
		
		List<String> listWindow = new ArrayList<String>(windowHandle);
					
		for(int i =0; i<listWindow.size();i++) {
	
			listWindow.get(i);
					
			String parentWin = listWindow.get(0);
			String childWin = listWindow.get(1);
			
			if(i==0) {
				
				driver.switchTo().window(childWin);
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
				
				driver.switchTo().window(parentWin);
				
			}
		System.out.println(driver.getCurrentUrl());
	}
	
	
	/*
	 * WebDriver Waits
	 *
	 */
	
	public String waitForTitle(int timeOut, String title) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}
	
	public String waitForText(int timeOut,By locator, String text)  {
		
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
		return driver.getTitle();
	}
	
	
	
}
