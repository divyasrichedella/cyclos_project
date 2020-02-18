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

import com.training.generics.ScreenShot;
import com.training.pom.PavLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PavTestLoan {

	private WebDriver driver;
	private String baseUrl;
	private PavLoginPOM pavLoginPOM;
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
		pavLoginPOM = new PavLoginPOM(driver); 
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
	@Test
	public void validLoginTest() throws InterruptedException {
		pavLoginPOM.sendUserName("admin");
		pavLoginPOM.But1();
		pavLoginPOM.But2();
		pavLoginPOM.But3();
		pavLoginPOM.But4();
		pavLoginPOM.submit();
		pavLoginPOM.member1();
        Thread.sleep(3000);
       pavLoginPOM.grant1();  
       pavLoginPOM.loan1();
       pavLoginPOM.dep();
       pavLoginPOM.subm();
       pavLoginPOM.subm1();
       Alert ae=driver.switchTo().alert();
	   ae.accept();
       pavLoginPOM.viewloan1();
       pavLoginPOM.logout1();
       Alert a=driver.switchTo().alert();
       a.accept();
		pavLoginPOM.sendUserName("pavan");
		pavLoginPOM.But11();
		pavLoginPOM.But21();
		pavLoginPOM.But31();
		pavLoginPOM.But41();
	

		pavLoginPOM.submit1();
		
		pavLoginPOM.accountLink();
		pavLoginPOM.loansLink();
		pavLoginPOM.viewIcon();
		pavLoginPOM.amountText();
		pavLoginPOM.repayBtn();
		//loginPOM.alertHandle();
		//loginPOM.alertHandle2();

		

	}
	
	
	
}
