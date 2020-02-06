package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReturnProduct_RTTC_036_POM {
	private WebDriver driver;
	public Actions act;
		
	public ReturnProduct_RTTC_036_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Login in to the application
	
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

	//Asserting and clicking on My Orders
	
	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a")
	private WebElement loginIcon;
	
	@FindBy(xpath="//span[contains(text(),'MY ORDERS')]")
	private WebElement myOrders;
	
	public void loginIconHover() {
		act = new Actions(driver);
		act.moveToElement(loginIcon).build().perform();
	}
	public void textVerification() {
		String expectedOption = "MY ORDERS";
		String actualOption = driver.findElement(By.xpath("//span[contains(text(),'MY ORDERS')]")).getText();
		assertEquals(actualOption, expectedOption);
		System.out.println(actualOption);
	}
	public void clickMyOrders() {
		this.myOrders.click();
	}
	public void assertOrderId() {
		String expectedOrderId="#214";
		String actualOrderId = driver.findElement(By.xpath("//td[contains(text(),'#214')]")).getText();
		assertEquals(actualOrderId, expectedOrderId);
		System.out.println(actualOrderId);
	}
	
	//View the order and click view button
	@FindBy(xpath="//*[@id=\"System_s3bhXNDb\"]/div[1]/table/tbody/tr[1]/td[7]/a/i")
	private WebElement vOrder;
	
	public void viewOrder() {
		this.vOrder.click();
	}
	
	public void assertOrderDetails() {
		String expectedOrderText="Order Details";
		String actualOrderText = driver.findElement(By.xpath("//td[contains(text(),'Order Details')]")).getText();
		assertEquals(actualOrderText, expectedOrderText);
		System.out.println(actualOrderText);
	}
	
	//Click on return button
	@FindBy(xpath="//i[@class='fa fa-reply']")
	private WebElement rButton;
	
	public void clickReturnButton() {
		this.rButton.click();
	}
	public void assertInformation() {
		String expectedInfo = "Order Information";
		String actualInfo = driver.findElement(By.xpath("//legend[contains(text(),'Order Information')]")).getText();
		assertEquals(actualInfo, expectedInfo);
		System.out.println(actualInfo);
	}
	
	//Selecting the reason
	@FindBy(xpath="//*[@id=\"return_request_form\"]/fieldset[2]/div[4]/div/div[1]/label/input")
	private WebElement radioBtn;
	
	public void selectRadioBtn() {
		boolean radioBtnIsSelected = radioBtn.isSelected();
		if (!radioBtnIsSelected) {
			radioBtn.click();
			System.out.println("Reason radio button was not checked.");
		} else {
			System.out.println("Reason radio button is already checked.");
		}
		
	}
	
	//Selecting product is opened
	@FindBy(xpath="//*[@class='col-sm-10']/label[1]/input")
	private WebElement radioBtn2;
	
	public void selectOpened() {
		boolean openedIsSelected = radioBtn2.isSelected();
		if(!openedIsSelected) {
			radioBtn2.click();
			System.out.println("Open radio button was not checked.");
		} else {
			System.out.println("Open radio button is already checked.");
		}
	}
	
	//Entering faulty or other details and clicking on submit button
	@FindBy(id="input-comment")
	private WebElement iComment;
	
	@FindBy(xpath="//input[contains(@class,'btn btn-primary')]")
	private WebElement sBtn;
	
	public void inputComment() {
		this.iComment.clear();
		this.iComment.sendKeys("Product is faulty.");
	}
	
	public void submitBtn() {
		this.sBtn.click();
	}
	
	public void confirmationMsg() {
		String expectedMsg="Thank you for submitting your return request. Your request has been sent to the relevant department for processing.";
		String actualMsg = driver.findElement(By.xpath("//p[contains(text(),'Thank you for submitting your return request. Your')]")).getText();
		assertEquals(actualMsg, expectedMsg);
		System.out.println(actualMsg);		
	}
	
}
