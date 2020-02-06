package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class AdminInvalidLogin_RTTC_037_POM {
	private WebDriver driver; 
	public Actions act;	

	public AdminInvalidLogin_RTTC_037_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//Login in to application
	@FindBy(id="input-username")
	private WebElement userName; 

	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(xpath="//button[contains(@class,'btn btn-primary')]")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement msgVerification;

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public void errorMsg() {
		String expectedErrorMsg = "No match for Username and/or Password.";
		String actualErrorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println(actualErrorMsg);
	}
}
