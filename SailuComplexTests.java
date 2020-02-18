package com.training.sanity.tests;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.training.dataproviders.SailuLoginDataProviders;
import com.training.generics.SailuScreenShot;
import com.training.pom.SailuComplexPOM;
import com.training.utility.SailuDriverFactory;
import com.training.utility.SailuDriverNames;


public class SailuComplexTests {
	private WebDriver driver;
	private String baseUrl;
	private SailuComplexPOM test_12;
	private static Properties properties;
	private SailuScreenShot sailuScreenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/Sailuothers.properties");
		properties.load(inStream);
//	}

	//@BeforeMethod
	//public void setUp() throws Exception {
		driver = SailuDriverFactory.getDriver(SailuDriverNames.CHROME);
		test_12 = new SailuComplexPOM(driver); 
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

	@Test (dataProvider="db-inputs",dataProviderClass=SailuLoginDataProviders.class)
	public void validLoginTest(String login,Integer amount,String description,String memberlogin) throws InterruptedException, AWTException  {
		test_12.sendUserName("admin");
		test_12.password1();
		test_12.password2();
		test_12.password3();
		test_12.password4();
		test_12.clickLoginBtn();
		
		
		test_12.clickAccounts();
		test_12.clickMemberpayment();
		test_12.sendMemberuserName(login);
		Thread.sleep(3000);
/*		test_12.sendMemberuserName();
		test_12.sendMemberuserName("i");
		test_12.sendMemberuserName();
*/		test_12.sendAmount(amount);
		test_12.list();
		/*Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);*/
		test_12.sendDescription(description);
		test_12.clickSubmit1();
		test_12.clickSubmit2();
		test_12.clickLogoutBtn();
		Alert d=driver.switchTo().alert();
		d.accept();
		
		
		test_12.sendUserName("admin");
		test_12.password1();
		test_12.password2();
		test_12.password3();
		test_12.password4();
		test_12.clickLoginBtn();
		
		
		
		test_12.sendMemberuser(memberlogin);
		test_12.clickAccinfo();
	//	screenShot.captureScreenShot("First");

	}
}
