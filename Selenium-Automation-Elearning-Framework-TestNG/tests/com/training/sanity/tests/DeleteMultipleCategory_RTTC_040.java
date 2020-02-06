package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.AppScreenShot;
import com.training.pom.DeleteMultipleCategory_RTTC_040_POM;
import com.training.pom.EditMetaTagTitle_RTTC_039_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteMultipleCategory_RTTC_040 {
	private WebDriver driver;
	private String baseUrl;
	private DeleteMultipleCategory_RTTC_040_POM deleteCategory;
	private static Properties properties;
	private AppScreenShot screenShot;
	
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		deleteCategory = new DeleteMultipleCategory_RTTC_040_POM(driver); 
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
		deleteCategory.sendUserName("admin");
		deleteCategory.sendPassword("admin@123");
		deleteCategory.clickLoginBtn(); 
	}
	@Test(priority=1)
	public void clickCategory()  {
		deleteCategory.catalogIconHover();
		deleteCategory.optionVerification();
		deleteCategory.clickCatalog();
		deleteCategory.nameVerification();
		screenShot.captureScreenShot("RTTC_040_1");
	}
	
	@Test(priority=2)
	public void selectCheckBoxes() throws InterruptedException {
		deleteCategory.selFirstChkBox();
		Thread.sleep(5000);
		deleteCategory.selSecondChkBox();
		Thread.sleep(5000);
		screenShot.captureScreenShot("RTTC_040_2");
	}
	@Test(priority=3)
	public void clickDeleteBtn() {
		deleteCategory.deleteButton();
		screenShot.captureScreenShot("RTTC_040_3");
	}
}
