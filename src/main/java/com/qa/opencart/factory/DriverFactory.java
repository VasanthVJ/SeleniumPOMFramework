package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private WebDriver driver;
	Properties prop;
	
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName =  prop.getProperty("browser");
		
		System.out.println("Browser name " +browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}else {
			
			System.out.println("Enter the correct browser name " +browserName);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url").trim());
		
		return driver;
		
	}
	
	public Properties ini_properties() {
		
		prop = new Properties();
		
		try {
			FileInputStream input = new 
					FileInputStream("C:/Users/vasanthakumar.j/eclipse-workspace/SelFrameWrk/src/test/resources/config/config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found");
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	
}


