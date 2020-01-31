package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveCart_RTTC_010 {
	private WebDriver driver;

	public RemoveCart_RTTC_010(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id=\"ProductsSystem_YD9pMDOx\"]/div[1]/div[4]/div/div[2]/div[1]/a/span/span/img") 
	private WebElement product;
	
	@FindBy(id="button-cart")
	private WebElement addToCartBtn;
	
//	@FindBy(xpath="//ul[@class='noty_cont noty_layout_topRight']")
//	private WebElement confirmationAlert;
	
	@FindBy(xpath="//i[contains(@class, 'tb_icon ico-linea-ecommerce-bag')]")
	private WebElement cartIcon;
	
	@FindBy(xpath="//a[contains(text(),'View Cart')]")
	private WebElement viewCart;
	
	@FindBy(xpath="//i[contains(@class, 'fa fa-times-circle')]")
	private WebElement removeCart;
	
	@FindBy(xpath="//i[contains(@class, 'fa fa-refresh')]")
	private WebElement refresh;
	
	public void clickProduct() {
		this.product.click();
	}
	
	public void clickAddToCart() {
		this.addToCartBtn.click();
	}
	
	public void cartHover() {
		act = new Actions(driver);
		act.moveToElement(cartIcon).build().perform();
	}
	
	public void clickViewCart() {
		this.viewCart.click();
		
	}
	public void textVerification() {
		String expectedText = "Total:";
		String actualText = driver.findElement(By.xpath("//*[@id=\"total\"]/tbody/tr[2]/td[1]/strong")).getText();
		assertEquals(actualText, expectedText);
		System.out.println(actualText);
	}
	
	public void clickRemoveCart() {
		this.removeCart.click();
	}
	
	public void clickRefresh() {
		this.refresh.click();
	}
	public void removalTextVerification() {
		String expectedRemovalText = "Your shopping cart is empty!";
		String actualRemovalText = driver.findElement(By.xpath("//p[contains(text(),'Your shopping cart is empty!')]")).getText();
		assertEquals(actualRemovalText, expectedRemovalText);
		System.out.println(actualRemovalText);
	}
}
