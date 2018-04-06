package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class WikiPage {
	
	
	private WebDriver driver;

	public WikiPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	

	
	
	@FindBy(name="quickedit")
	public WebElement creeatePageButton;
	
	@FindBy(xpath = "//input[@id='pagename']")
	public WebElement pagename;
	
	@FindBy(xpath="//textarea[@id='editwiki']")
	public WebElement pageContent;
	
	@FindBy(xpath="//input[@name='save']")
	public WebElement saveButton;

}
