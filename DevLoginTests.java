package com.training.sanity.tests;

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

import com.training.generics.ScreenShot1;
import com.training.pom.DevLoginPOM;
import com.training.utility.DriverFactory1;
import com.training.utility.DriverNames1;

public class DevLoginTests {

	private WebDriver driver;
	private String baseUrl;
	private DevLoginPOM devLoginPOM;
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
		devLoginPOM = new DevLoginPOM(driver); 
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
		devLoginPOM.sendUserName("admin");
		
		devLoginPOM.password1();
		devLoginPOM.password2();
		devLoginPOM.password3();
		devLoginPOM.password4();
		devLoginPOM.clickLoginBtn();
		Thread.sleep(3000);
		//loginPOM.clickLogoutBtn();
		//driver.findElement(By.id("memberUsername")).sendKeys("sree");
		devLoginPOM.membername("sree");
		Thread.sleep(3000);  
			      
	    
	    //driver.findElement(By.xpath("//input[@linkurl='grantLoan?memberId=12']")).click();
		devLoginPOM.grant();
		devLoginPOM.amount("4567");
		//driver.findElement(By.id("amount")).sendKeys("4567");
			//driver.findElement(By.id("description")).sendKeys("Home Loan");
		devLoginPOM.des("Home Loan");
		devLoginPOM.sub();
			//driver.findElement(By.xpath("//input[@type='submit']")).click();
			
		devLoginPOM.sub1();
		devLoginPOM.alertHandle1();
			//driver.findElement(By.xpath("//input[@linkurl='searchLoans?memberId=12']")).click();
		devLoginPOM.view();
			//driver.findElement(By.id("menu15")).click();
		devLoginPOM.view1();
		devLoginPOM.alertHandle2();
			
			devLoginPOM.sendUserName("sree");
			
			devLoginPOM.password1();
			devLoginPOM.password2();
			devLoginPOM.password3();
			devLoginPOM.password4();
			devLoginPOM.clickLoginBtn();
			//driver.findElement(By.xpath("//li[@id='menu2']")).click();
			devLoginPOM.men();
			//driver.findElement(By.id("submenu2.3")).click();
			
			devLoginPOM.men1();

			


		

		//screenShot.captureScreenShot("First");
	}
}
