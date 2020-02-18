package com.training.sanity.tests;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.SailuScreenShot;
import com.training.pom.SailuAdminloginPOM;
import com.training.pom.SailuTransactionPOM;
import com.training.pom.SailuAccinfoPOM;

import com.training.utility.SailuDriverFactory;
import com.training.utility.SailuDriverNames;

public class SailuMediumTests {

	private WebDriver driver;
	private String baseUrl;
	private SailuAdminloginPOM SailuAdminloginPOM;
	private SailuTransactionPOM SailuTransactionPOM;
	private SailuAccinfoPOM SailuAccinfoPOM;
	private static Properties properties;
	private SailuScreenShot sailuScreenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/Sailuothers.properties");
		properties.load(inStream);
		driver = SailuDriverFactory.getDriver(SailuDriverNames.CHROME);
		SailuAdminloginPOM = new SailuAdminloginPOM(driver);
		SailuTransactionPOM = new SailuTransactionPOM(driver); 
		SailuAccinfoPOM = new SailuAccinfoPOM(driver); 

		baseUrl = properties.getProperty("baseURL");
		sailuScreenShot = new SailuScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);

	}



	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}

	@Test (priority=0)
	public void validLoginTest()   {
		SailuAdminloginPOM.sendUserName("admin");
		SailuAdminloginPOM.password1();
		SailuAdminloginPOM.password2();
		SailuAdminloginPOM.password3();
		SailuAdminloginPOM.password4();
		SailuAdminloginPOM.clickLoginBtn();
	}

	@Test (priority=1)
	public void transaction() throws InterruptedException {
		SailuTransactionPOM.clickAccounts();
		SailuTransactionPOM.clickMemberpayment();
		SailuTransactionPOM.sendMemberuserName("sai");
		Thread.sleep(3000);
		SailuTransactionPOM.sendAmount("1234");
		SailuTransactionPOM.list();
		SailuTransactionPOM.sendDescription("birth day gift");
		SailuTransactionPOM.clickSubmit1();
		SailuTransactionPOM.clickSubmit2();
		SailuTransactionPOM.clickLogoutBtn();
		Alert d=driver.switchTo().alert();
		d.accept();
	}

	@Test (priority=2)
	public void validLoginTest1()   {
		SailuAdminloginPOM.sendUserName("admin");
		SailuAdminloginPOM.password1();
		SailuAdminloginPOM.password2();
		SailuAdminloginPOM.password3();
		SailuAdminloginPOM.password4();
		SailuAdminloginPOM.clickLoginBtn();

	}


	@Test (priority=3)
	public void accinfo()  {
		SailuAccinfoPOM.sendMemberuser("sailaja");
		SailuAccinfoPOM.clickAccinfo();
		//screenShot.captureScreenShot("First");       

		
	}
}
