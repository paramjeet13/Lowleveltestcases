package com.training.pom;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginForChangePassword_RTTC_006 {
	private WebDriver driver; 


	public LoginForChangePassword_RTTC_006(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//i[contains(@class, 'fa fa-user-o')]")
	private WebElement login;

	@FindBy(xpath="//span[contains(text(),'LOGIN / REGISTER')]")
	private WebElement loginLink;

	@FindBy(id="input-email")
	private WebElement userName; 

	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(xpath="//input[contains(@class, 'btn btn-primary')]")
	private WebElement loginBtn;


	public Actions act;
	public void loginHover() {
		act = new Actions(driver);
		act.moveToElement(login).build().perform();
	}

	public void loginClick() {
		act = new Actions(driver);
		act.moveToElement(loginLink).click().build().perform();
	}

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

	@FindBy(xpath="//a[contains(text(), 'Change your password')]")
	private WebElement changePwdLink;

	@FindBy(id="input-password")    //Re-enter password
	private WebElement pwd;

	@FindBy(id="input-confirm")     //Confirm password
	private WebElement repwd;

	public void clickChangePwdLink() {
		this.changePwdLink.click();
	}
	public void sPassword(String pwd) {
		this.pwd.clear();        //Re-enter password
		this.pwd.sendKeys(pwd); 
	}
	public void cPassword(String repwd) {
		this.repwd.clear();      //Confirm password
		this.repwd.sendKeys(repwd); 
	}
	@FindBy(xpath="//input[contains(@class, 'btn btn-primary')]")
	private WebElement continueBtn;

	public void clickContinueBtn() {
		this.continueBtn.click();
	}
	public void msgVerification() {
		String expectedMsg = "Success: Your password has been successfully updated.";
		String actualMsg = driver.findElement(By.xpath("//div[contains(@class, 'alert alert-success')]")).getText();
		assertEquals(actualMsg, expectedMsg);
		System.out.println(actualMsg);
	}

}
