package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategory_RTTC_038_POM {
	private WebDriver driver; 
	public Actions act;	
	
	public AddCategory_RTTC_038_POM(WebDriver driver) {
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
	
	//Hovering and clicking on categories link
	@FindBy(xpath="//i[contains(@class,'fa fa-tags fw')]")
	private WebElement catalogIcon;
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement catalogLink;
	
	public void catalogIconHover() {
		act = new Actions(driver);
		act.moveToElement(catalogIcon).build().perform();
	}
	public void optionVerification() {
		String expectedOption = "Categories";
		String actualOption = driver.findElement(By.xpath("//a[contains(text(),'Categories')]")).getText();
		assertEquals(actualOption, expectedOption);
		System.out.println(actualOption);
	}
	
	public void clickCatalog() {
		this.catalogLink.click();
	}
	public void nameVerification() {
		String expectedName="Category Name";
		String actualName = driver.findElement(By.xpath("//a[@class='asc']")).getText();
		assertEquals(actualName, expectedName);
		System.out.println(actualName);
	}
	
	//Adding new category
	@FindBy(xpath="//i[contains(@class,'fa fa-plus')]")
	private WebElement addBtn;
		
	public void clickAddBtn() {
		this.addBtn.click();
	}
	
	//Filling the form for creating category under General tab
	@FindBy(id="input-name1")
	private WebElement catName;
	
	@FindBy(xpath="//div[contains(@class,'note-editable panel-body')]")
	private WebElement desField;
	
	@FindBy(id="input-meta-title1")
	private WebElement mTagTitle;
	
	@FindBy(id="input-meta-description1")
	private WebElement mTagDescription;
	
	public void categoryName() {
		this.catName.clear();
		this.catName.sendKeys("TESTORNAMENT");
	}
	
	public void descriptionField() {
		this.desField.clear();
		this.desField.sendKeys("Test Ornament");
	}
	
	public void metaTagTitle() {
		this.mTagTitle.clear();
		this.mTagTitle.sendKeys("TESTORNAMENT");
	}
	
	public void metaTagDescription() {
		this.mTagDescription.clear();
		this.mTagDescription.sendKeys("Test Ornament");
	}
	
	//Keeping default value under Data and Design tab and saving
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement data;
	
	@FindBy(xpath="//a[contains(text(),'Design')]")
	private WebElement design;
	
	@FindBy(xpath="//i[contains(@class,'fa fa-save')]")
	private WebElement cSave;
	
	public void dataTab() {
		this.data.click();
	}
	
	public void designTab() {
		this.design.click();
	}
	
	public void clickSave() {
		this.cSave.click();
	}
	
	public void successMsg() {
		String expectedMsg = "Success: You have modified categories! ";
		String actualMsg = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]")).getText();
		assertEquals(actualMsg, expectedMsg);
		System.out.println(actualMsg);
	}
	
}
