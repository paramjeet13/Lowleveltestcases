package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.generics.AppScreenShot;
import com.training.pom.AdminInvalidLogin_RTTC_037_POM;
import com.training.pom.DeleteMultipleCategory_RTTC_040_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminInvalidLogin_RTTC_037 {
	private WebDriver driver;
	private String baseUrl;
	private AdminInvalidLogin_RTTC_037_POM invalidLogin;
	private static Properties properties;
	private AppScreenShot screenShot;
	
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		invalidLogin = new AdminInvalidLogin_RTTC_037_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new AppScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test (dataProvider = "wrongLoginCreds")
	public void wrongCreds(String username, String password) {
		invalidLogin.sendUserName(username);
		invalidLogin.sendPassword(password);
		invalidLogin.clickLoginBtn();
		invalidLogin.errorMsg();
		
	}
	
	@DataProvider
	public Object[][] wrongLoginCreds(){
		return new Object[][] {
			new Object[] {"admin", "123456"},
			new Object[] {"admin", "admin"},
			new Object[] {"test", "admin@123"},
			new Object[] {"admin@123", "admin@123"}
		};
	}
}
