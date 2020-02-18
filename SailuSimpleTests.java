package com.training.sanity.tests;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.training.generics.SailuScreenShot;
import com.training.pom.SailuLoginPOM;
import com.training.pom.SailuSimplePOM;
import com.training.utility.SailuDriverFactory;
import com.training.utility.SailuDriverNames;


public class SailuSimpleTests {
	private WebDriver driver;
	private String baseUrl;
	private SailuSimplePOM test_12;
	private static Properties properties;
	private SailuScreenShot sailuScreenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/Sailuothers.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = SailuDriverFactory.getDriver(SailuDriverNames.CHROME);
		test_12 = new SailuSimplePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		sailuScreenShot = new SailuScreenShot(driver); 
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
		test_12.sendUserName("admin");
		test_12.password1();
		test_12.password2();
		test_12.password3();
		test_12.password4();
		test_12.clickLoginBtn(); 
		test_12.clickLogoutBtn();
		Alert d=driver.switchTo().alert();
		d.accept();
		sailuScreenShot.captureScreenShot("First");

	}
}
