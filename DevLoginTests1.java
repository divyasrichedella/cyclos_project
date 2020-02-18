package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot1;
import com.training.pom.DevLoginPOM1;
import com.training.utility.DriverFactory1;
import com.training.utility.DriverNames1;

public class DevLoginTests1 {

	private WebDriver driver;
	private String baseUrl;
	private DevLoginPOM1 devLoginPOM1;
	private static Properties properties;
	private ScreenShot1 screenShot1;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others1.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory1.getDriver(DriverNames1.CHROME);
		devLoginPOM1 = new DevLoginPOM1(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot1 = new ScreenShot1(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		devLoginPOM1.sendUserName("sree");
		
		devLoginPOM1.password1();
		devLoginPOM1.password2();
		devLoginPOM1.password3();
		devLoginPOM1.password4();
		devLoginPOM1.clickLoginBtn();
		Thread.sleep(3000);
		devLoginPOM1.clickLogoutBtn();
		devLoginPOM1.alert();

		//screenShot.captureScreenShot("First");
	}
}
