package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.pom.InvalidPassword_RTTC_007;
import com.training.pom.LoginForChangePassword_RTTC_006;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class InvalidConfirmPassword_RTTC_007 {
	private WebDriver driver;
	private String baseUrl;
	private InvalidPassword_RTTC_007 invalidPassword;
	private static Properties properties;
	//private ScreenShot screenShot;
	
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		invalidPassword = new InvalidPassword_RTTC_007(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	/*
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginForChangePassword = new LoginForChangePassword_RTTC_006(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	} */
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=0)
	public void validLoginTest() {
		invalidPassword.loginHover();
		invalidPassword.loginClick();
		invalidPassword.sendUserName("test@gmail.com");
		invalidPassword.sendPassword("test123");
		invalidPassword.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
	}
	@Test(priority=1)
	public void changePassword() {
		invalidPassword.clickChangePwdLink();
		invalidPassword.cPassword("test123");
		invalidPassword.sPassword("test12");
		invalidPassword.clickContinueBtn();
		invalidPassword.msgVerification(); //Asserting by accessing method
		
	}

}
