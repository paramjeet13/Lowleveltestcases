package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.pom.FingerRingAddToCart_RTTC_009;
import com.training.pom.RemoveCart_RTTC_010;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CartRemoval_RTTC_010 {
	private WebDriver driver;
	private String baseUrl;
	private RemoveCart_RTTC_010 cartRemoval;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		cartRemoval = new RemoveCart_RTTC_010(driver); 
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

		cartRemoval.searchAction();
		cartRemoval.searchClick("Finger Ring");
		cartRemoval.clickProduct();
		cartRemoval.clickAddToCart();
		cartRemoval.cartHover();
		cartRemoval.clickViewCard();
		cartRemoval.textVerification();
		cartRemoval.clickRemoveCart();
		cartRemoval.clickRefresh();
		cartRemoval.removalTextVerification();

	}
}
