package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.AppScreenShot;
import com.training.pom.LoginForChangePassword_RTTC_006;
import com.training.pom.SearchFingerRing_RTTC_008;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FingerRingSearch_RTTC_008 {
	private WebDriver driver;
	private String baseUrl;
	private SearchFingerRing_RTTC_008 searchFingerRing;
	private static Properties properties;
	private AppScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		searchFingerRing = new SearchFingerRing_RTTC_008(driver); 
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

	@Test
	public void validLoginTest() throws InterruptedException {

		searchFingerRing.searchAction();
		searchFingerRing.searchClick("Finger Ring");
		searchFingerRing.dropDownSelect();
		screenShot.captureScreenShot("RTTC_008");

	}

}
