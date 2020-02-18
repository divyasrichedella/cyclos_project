package com.training.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * 
 * @author Naveen
 * @see This class will load the given driver, and follows factory pattern 
 * 	@since 16-Dec-2018 
 */
public class DriverFactory1 {
	// it only a reference 
	private static WebDriver driver; 
	
	public static WebDriver getDriver(String driverName){

		if(driverName.equals(DriverNames1.CHROME)){
			System.setProperty(Driver1.CHROME, Driver1.CHROME_PATH);
			driver = new ChromeDriver();
		
			
		}else if(driverName.equals(DriverNames1.FIREFOX)){
			System.setProperty(Driver1.FIREFOX, Driver1.FIREFOX_PATH);
			driver = new FirefoxDriver();
			
		}else if(driverName.equals("IE")){
			// TODO 
		}else if(driverName.equals(DriverNames1.PHANTOM)){
			// TODO 
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}