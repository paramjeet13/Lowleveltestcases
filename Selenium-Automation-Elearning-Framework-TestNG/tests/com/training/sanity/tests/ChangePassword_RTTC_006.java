package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginForChangePassword_RTTC_006;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangePassword_RTTC_006 {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginForChangePassword_RTTC_006 loginForChangePassword;
	private static Properties properties;
	//private ScreenShot screenShot;
	
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginForChangePassword = new LoginForChangePassword_RTTC_006(driver); 
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
		loginForChangePassword.loginHover();
		loginForChangePassword.loginClick();
		loginForChangePassword.sendUserName("test@gmail.com");
		loginForChangePassword.sendPassword("test123");
		loginForChangePassword.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
	}
	@Test(priority=1)
	public void changePassword() {
		loginForChangePassword.clickChangePwdLink();
		loginForChangePassword.cPassword("test123");
		loginForChangePassword.sPassword("test123");
		loginForChangePassword.clickContinueBtn();
		loginForChangePassword.msgVerification();  //Asserting by accessing method
		
	}
	

}
