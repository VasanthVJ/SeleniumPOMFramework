package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;

public class ProductInfoTest extends BaseTest{
	
	SoftAssert softAssert = new SoftAssert();
	
	
	
	@BeforeClass
	public void productInfoSetUp() {
		
		accPage = login.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));
	}
	
	@Test
	public void doSearchTest() {
		
		searchProductInfo = accPage.doSearch("iMac");
		productInfo = searchProductInfo.selectProductFromResults("iMac");
		assertEquals(productInfo.getProductHeader(), "iMac");
		
		
	}
	
	@Test
	public void serachResultCount() {
		
		searchProductInfo = accPage.doSearch("macbook");
		int count = searchProductInfo.getProductResultCount();
		System.out.println("Product result count " +count);
		Assert.assertTrue(searchProductInfo.getProductResultCount()==3);		
		
	}
	
	@Test
	public void imagesCountTest() {
		
		searchProductInfo = accPage.doSearch("mac");
		productInfo = searchProductInfo.selectProductFromResults("MacBook Air");
		int imageCount = productInfo.getProductImagesCount();
		System.out.println("Total number of images: " +imageCount);
		Assert.assertEquals(imageCount, 4);		
	}
	
	@Test
	public void productDescriptionTest() {
		
		searchProductInfo = accPage.doSearch("mac");
		productInfo = searchProductInfo.selectProductFromResults("MacBook Air");
		
		
		Map<String, String> actalMetaMap= productInfo.getProductDescription();
		
		actalMetaMap.forEach((k,v) ->System.out.println("Key " +k+ "Value " +v));;
		
		softAssert.assertEquals(actalMetaMap.get("name"), "MacBook Air");
		
		
		
	
	}
	
	

}
