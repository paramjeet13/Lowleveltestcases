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
import com.training.pom.ReturnProduct_RTTC_036_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCategory_RTTC_038 {
	private WebDriver driver;
	private String baseUrl;
	private AddCategory_RTTC_038_POM addCategory;
	private static Properties properties;
	private AppScreenShot screenShot;
	
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addCategory = new AddCategory_RTTC_038_POM(driver); 
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
		addCategory.sendUserName("admin");
		addCategory.sendPassword("admin@123");
		addCategory.clickLoginBtn(); 
		screenShot.captureScreenShot("RTTC_038_1");	
	}
	@Test(priority=1)
	public void clickCategory()  {
		addCategory.catalogIconHover();
		addCategory.optionVerification();
		addCategory.clickCatalog();
		addCategory.nameVerification();
		screenShot.captureScreenShot("RTTC_038_2");
	}
	@Test(priority=2)
	public void addingCategory() throws InterruptedException {
		addCategory.clickAddBtn();
		addCategory.categoryName();
		addCategory.descriptionField();
		addCategory.metaTagTitle();
		addCategory.metaTagDescription();
		Thread.sleep(5000);
		screenShot.captureScreenShot("RTTC_038_3");
	}
	@Test(priority=3)
	public void addDesignTab() throws InterruptedException {
		addCategory.dataTab();
		Thread.sleep(5000);
		addCategory.designTab();
		Thread.sleep(5000);
		addCategory.clickSave();
		addCategory.successMsg();
		screenShot.captureScreenShot("RTTC_038_4");
	}

}
