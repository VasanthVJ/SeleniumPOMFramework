package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtility;

public class ProductInfo {
	
	private WebDriver driver;
	private ElementUtility elementUtil;
	
	private By productHeader = By.cssSelector("div#content h1");
	private By productImage = By.cssSelector("ul.thumbnails li img");
	private By productMetaData = By.cssSelector("div #content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div #content ul.list-unstyled:nth-of-type(2) li");
	private By productQuantity = By.id("input-quantity");
	private By addCart = By.id("button-cart");
	
	
	public ProductInfo(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtility(driver);
	}
	
	public String getProductHeader() {
		return elementUtil.getText(productHeader);	
	}
	
	public int getProductImagesCount() {
		return elementUtil.getElements(productImage).size();
	}
	
	public Map<String, String> getProductDescription() {
		
		Map<String, String> productInfoMap = new HashMap<String, String>();
		productInfoMap.put("name", getProductHeader());
		
		List<WebElement> productMetaList = elementUtil.getElements(productMetaData);
		System.out.println("Size of the Meta product List " +productMetaList.size());
		
		for(WebElement e: productMetaList) {
			
			String meta[] = e.getText().split(":");
			String metaListKey = meta[0].trim();
			String metaListValue = meta[1].trim();
			productInfoMap.put(metaListKey,metaListValue);
		}
		
		List<WebElement> priceList = elementUtil.getElements(productPriceData);
		

		String price = priceList.get(0).getText().trim();
		String extraTax = priceList.get(1).getText().trim();
		
		productInfoMap.put("price", price);
		productInfoMap.put("priceWithTax", extraTax);
		
		return productInfoMap;
	}
	
	public void setQuantity(String quantity) {
		
		elementUtil.doSendKeys(productQuantity, quantity);
	}
	
	public void addToCart() {
		elementUtil.doClick(addCart);	
	}

}
