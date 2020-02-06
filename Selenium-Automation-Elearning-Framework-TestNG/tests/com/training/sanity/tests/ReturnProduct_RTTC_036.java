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
import com.training.pom.ReturnProduct_RTTC_036_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReturnProduct_RTTC_036 {
	private WebDriver driver;
	private String baseUrl;
	private ReturnProduct_RTTC_036_POM returnOrder;
	private static Properties properties;
	//private AppScreenShot screenShot;
	
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		returnOrder = new ReturnProduct_RTTC_036_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new AppScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=0)
	public void validLoginTest() {
		returnOrder.loginHover();
		returnOrder.loginClick();
		returnOrder.sendUserName("test@gmail.com");
		returnOrder.sendPassword("test123");
		returnOrder.clickLoginBtn(); 
			
	}
	@Test(priority=1)
	public void clickMyOrdersOption() {
		returnOrder.loginIconHover();
		returnOrder.textVerification();
		returnOrder.clickMyOrders();
		returnOrder.assertOrderId();
		//screenShot.captureScreenShot("RTTC_036_1");
	}
	
	@Test(priority=2)
	public void orderView() {
		returnOrder.viewOrder();
		returnOrder.assertOrderDetails();
		//screenShot.captureScreenShot("RTTC_036_2");
	}
	@Test(priority=3)
	public void clickRtrBtn() {
		returnOrder.clickReturnButton();
		returnOrder.assertInformation();
		//screenShot.captureScreenShot("RTTC_036_3");
	}
	@Test(priority=4)
	public void selectReason() {
		returnOrder.selectRadioBtn();
		returnOrder.selectOpened();
		returnOrder.inputComment();
		//screenShot.captureScreenShot("RTTC_036_4");
	}
	@Test(priority=5)
	public void clickSubmit() {
		returnOrder.submitBtn();
		returnOrder.confirmationMsg();
		//screenShot.captureScreenShot("RTTC_036_5");
	}
}
