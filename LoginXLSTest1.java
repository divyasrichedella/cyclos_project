package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean1;
import com.training.dao.ELearningDAO1;
import com.training.dataproviders.LoginDataProviders1;
import com.training.generics.ScreenShot1;
import com.training.pom.DevLoginPOM1;
import com.training.readexcel.ReadExcel1;
import com.training.utility.DriverFactory1;
import com.training.utility.DriverNames1;

public class LoginXLSTest1 {
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

	@Test(dataProvider = "xls-inputs", dataProviderClass = LoginDataProviders1.class)
	public void loginDBTest(String userName, String password) {
		devLoginPOM1.sendUserName(userName);
		//loginPOM.sendPassword(password);
		devLoginPOM1.clickLoginBtn();
		screenShot1.captureScreenShot(userName);

	}

}