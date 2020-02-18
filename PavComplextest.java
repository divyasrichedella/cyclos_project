package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.PavLoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.PavComplexPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PavComplextest {

	private WebDriver driver;
	private String baseUrl;
	private PavComplexPOM pavComplexPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		pavComplexPOM = new PavComplexPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(dataProvider="cyclos",dataProviderClass=PavLoginDataProviders.class)
	public void validLoginTest(String Member_Login,String Amount,String Transaction_Type,String Description) throws InterruptedException {
		pavComplexPOM.sendUserName("admin");
		pavComplexPOM.sendUserPassword();
		pavComplexPOM.bttn1();
		pavComplexPOM.bttn2();
		pavComplexPOM.bttn3();
		pavComplexPOM.bttn4();
		pavComplexPOM.clicksubmitbtn();
		 Thread.sleep(3000);
		 pavComplexPOM.memberUsername(Member_Login);
		 pavComplexPOM.Account();
		 pavComplexPOM.SystemPayment();
		 pavComplexPOM.Amount(Amount);
		 pavComplexPOM.Transaction(Transaction_Type);
		 WebElement a=driver.findElement(By.id("type"));
		 Select sel=new Select(a);
		 sel.selectByValue("1");
		 pavComplexPOM.Description(Description);
		 Thread.sleep(3000);
		 pavComplexPOM.Submit();
		 Thread.sleep(2000);
		 pavComplexPOM.FinalSubmit();
		
		
		
		
	}
}
