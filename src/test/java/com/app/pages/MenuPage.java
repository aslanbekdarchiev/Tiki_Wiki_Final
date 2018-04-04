package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class MenuPage {
	WebDriver driver;

	public MenuPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ul[@id='menu_option51']/..")
	public WebElement articlesDropDown;
	
	@FindBy(xpath="//ul[@id='menu_option51']//li[3]")
	public WebElement newArticleFromArticleDropDown;
	
	@FindBy(xpath="//ul[@id='menu_option51']//li[2]")
	public WebElement listArticleFromArticleDropDown;
	
	@FindBy(xpath="//ul[@id='menu_option51']//li[4]")
	public WebElement adminTopicsFromArticleDropDown;
	
	
}
