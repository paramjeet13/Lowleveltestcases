package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchFingerRing_RTTC_008 {
	private WebDriver driver;

	public SearchFingerRing_RTTC_008(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="search_button")
	private WebElement searchBtn;

	@FindBy(id="filter_keyword")
	private WebElement search;

	public Actions act;
	public void searchAction() {
		act = new Actions(driver);
		act.moveToElement(searchBtn).build().perform();
	}

	public void searchClick(String search) {
		this.search.clear();
		this.search.sendKeys(search);
		this.searchBtn.click();
	}

	@FindBy(xpath="//div[@class='sort']//select") 
	private WebElement dropDown;

	public Select selFromDropDown;
	public void dropDownSelect() throws InterruptedException {
		selFromDropDown = new Select(dropDown);  
		this.dropDown.click();
		this.selFromDropDown.selectByVisibleText("Name (A - Z)");
		Thread.sleep(5000);
		this.selFromDropDown.selectByVisibleText("Rating (Highest)");
	}
}
