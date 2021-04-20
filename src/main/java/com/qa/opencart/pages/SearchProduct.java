package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtility;

public class SearchProduct {

	private ElementUtility elementUtil;
	WebDriver driver;
	
	private By searchItemResult = By.cssSelector("div product-thumb");
	private By resultItems = By.cssSelector("div.product-thumb h4 a");
	
	public SearchProduct(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtility(driver);
		
	}
	
	public int getProductResultCount() {
		return elementUtil.getElements(searchItemResult).size();
	}
	
	public ProductInfo selectProductFromResults(String productName) {
		List<WebElement> productList = elementUtil.getElements(resultItems);
		System.out.println("Product Entered " +productName);
		for(WebElement e: productList) {
			if(e.getText().equals(productName)) {
				e.click();	
				break;
			}
						
		}
		
		return new ProductInfo(driver);
		
	}

}
