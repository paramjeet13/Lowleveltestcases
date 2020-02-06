package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.AppScreenShot;
import com.training.pom.AddCategory_RTTC_038_POM;
import com.training.pom.EditMetaTagTitle_RTTC_039_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditMetaTagTitle_RTTC_039 {
	private WebDriver driver;
	private String baseUrl;
	private EditMetaTagTitle_RTTC_039_POM editMetaTagTitle;
	private static Properties properties;
	private AppScreenShot screenShot;
	
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		editMetaTagTitle = new EditMetaTagTitle_RTTC_039_POM(driver); 
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
	
	@Test(priority=0)
	public void validLoginTest() {
		editMetaTagTitle.sendUserName("admin");
		editMetaTagTitle.sendPassword("admin@123");
		editMetaTagTitle.clickLoginBtn(); 
		screenShot.captureScreenShot("RTTC_039_1");	
	}
	@Test(priority=1)
	public void clickCategory()  {
		editMetaTagTitle.catalogIconHover();
		editMetaTagTitle.optionVerification();
		editMetaTagTitle.clickCatalog();
		editMetaTagTitle.nameVerification();
		screenShot.captureScreenShot("RTTC_039_2");
	}
	
	@Test(priority=2)
	public void clickEditBtn() throws InterruptedException {
		editMetaTagTitle.editBtn();
		editMetaTagTitle.editMetaTagTitle();
		editMetaTagTitle.editMetaTagDesc();
		screenShot.captureScreenShot("RTTC_039_3");
		editMetaTagTitle.dataTab();
		Thread.sleep(2000);
		editMetaTagTitle.designTab();
		Thread.sleep(2000);
	}
	@Test(priority=3)
	public void clickSaveBtn() throws InterruptedException {
		editMetaTagTitle.clickSave();
		editMetaTagTitle.successEditMsg();
		screenShot.captureScreenShot("RTTC_039_4");
	}
	
}
