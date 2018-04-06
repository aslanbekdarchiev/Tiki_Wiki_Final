package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class ListWikiPages {

	private WebDriver driver;

	public ListWikiPages() {
			this.driver = Driver.getDriver();
			PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath="(//a[@class='link tips'])[1]")
	public WebElement contIntPage;
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public WebElement editButton;
	
	@FindBy(xpath="(//td[contains(text(),'Updated')])[1]")
	public WebElement updatedStatus;
	
	@FindBy(xpath="//input[@id='find']")
	public WebElement searchButton;
	
	@FindBy(xpath="//button[contains(text(),'Find')]")
	public WebElement findButton;
}
