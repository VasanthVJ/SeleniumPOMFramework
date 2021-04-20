package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfo;
import com.qa.opencart.pages.SearchProduct;

public class BaseTest {
	
	DriverFactory df;
	public WebDriver driver;
	public Properties prop;
	
	
	public LoginPage login;
	public AccountsPage accPage;
	public ProductInfo productInfo;
	public SearchProduct searchProductInfo;
	
	@BeforeTest()
	public void setUp() {
		df = new DriverFactory();
		prop = df.ini_properties();
		driver = df.init_driver(prop);
		login = new LoginPage(driver);
	}
	
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
		
	}
	
	

}
