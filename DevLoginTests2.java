package com.training.sanity.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders1;
import com.training.generics.ScreenShot1;
import com.training.pom.DevLoginPOM;
import com.training.pom.DevLoginPOM2;
import com.training.utility.DriverFactory1;
import com.training.utility.DriverNames1;

public class DevLoginTests2 {

	private WebDriver driver;
	private String baseUrl;
	private DevLoginPOM2 devLoginPOM2;
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
		devLoginPOM2 = new DevLoginPOM2(driver); 
		
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
	
	@Test(dataProvider="db-inputs",dataProviderClass=LoginDataProviders1.class)
	public void validLoginTest(String Member_Login,String Title_textbox,String Price,String Description) throws InterruptedException, AWTException {
		devLoginPOM2.sendUserName("admin");
		
		devLoginPOM2.password1();
		devLoginPOM2.password2();
		devLoginPOM2.password3();
		devLoginPOM2.password4();
		devLoginPOM2.clickLoginBtn();
		Thread.sleep(3000);
		
		devLoginPOM2.membername(Member_Login);
		Thread.sleep(3000);  
			      
		devLoginPOM2.exe();
		devLoginPOM2.clickMansubbtn();
		devLoginPOM2.clicknewButton();
		devLoginPOM2.title(Title_textbox);
		devLoginPOM2.clickCategory();
		  Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        devLoginPOM2.sendUnits(Price);
        devLoginPOM2.clicknotExpirableCheck();
        driver.switchTo().parentFrame();
        devLoginPOM2.sendbody(Description);
       devLoginPOM2.clicksaveButton();
        Alert d=driver.switchTo().alert();
		d.accept();
        devLoginPOM2.clickbackButton();

		

	}
}
