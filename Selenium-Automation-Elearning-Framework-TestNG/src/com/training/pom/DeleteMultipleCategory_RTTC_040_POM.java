package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteMultipleCategory_RTTC_040_POM {
	private WebDriver driver; 
	public Actions act;	
	
	public DeleteMultipleCategory_RTTC_040_POM(WebDriver driver) {
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
	
	//Selecting the multiple checkbox
	@FindBy(xpath="//*[@id='form-category']/div/table/tbody/tr[2]/td[1]/input")
	private WebElement fChkBox;
	
	@FindBy(xpath="//*[@id='form-category']/div/table/tbody/tr[3]/td[1]/input")
	private WebElement sChkBox;
	
	public void selFirstChkBox() {
		boolean fChkBoxIsSelected = fChkBox.isSelected();
		if (!fChkBoxIsSelected) {
			fChkBox.click();
			System.out.println("Reason radio button was not checked.");
		} else {
			System.out.println("Reason radio button is already checked.");
		}
	}
	public void selSecondChkBox() {
		boolean sChkBoxIsSelected = sChkBox.isSelected();
		if (!sChkBoxIsSelected) {
			sChkBox.click();
			System.out.println("Reason radio button was not checked.");
		} else {
			System.out.println("Reason radio button is already checked.");
		}
	}
	
	//Clicking on delete button and confirming in pop up
	@FindBy(xpath="//i[contains(@class, 'fa fa-trash-o')]")
	private WebElement delButton;
	
	public void deleteButton() {
		this.delButton.click();
		Alert confirmationAlert = driver.switchTo().alert();
		String confirmationText = confirmationAlert.getText();
		System.out.println(confirmationText);
		confirmationAlert.accept();
		assertEquals(driver.findElement(By.xpath("//div[contains(@class, 'alert alert-success')]")).getText(), "Success: You have modified categories!");
		System.out.println(driver.findElement(By.xpath("//div[contains(@class, 'alert alert-success')]")).getText());
		
	}
	
}
