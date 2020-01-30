package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.pom.FingerRingAddToCart_RTTC_009;
import com.training.pom.SearchFingerRing_RTTC_008;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddToCartFingerRing_RTTC_009 {
	private WebDriver driver;
	private String baseUrl;
	private FingerRingAddToCart_RTTC_009 addToCartFingerRing;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addToCartFingerRing = new FingerRingAddToCart_RTTC_009(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
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

		addToCartFingerRing.searchAction();
		addToCartFingerRing.searchClick("Finger Ring");
		addToCartFingerRing.clickProduct();
		addToCartFingerRing.clickAddToCart();
		addToCartFingerRing.cartHover();
		addToCartFingerRing.clickViewCard();
		addToCartFingerRing.textVerification();

	}
}
