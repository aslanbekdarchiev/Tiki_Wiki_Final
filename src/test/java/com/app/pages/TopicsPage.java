package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class TopicsPage {
	private WebDriver driver;

	public TopicsPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="name")
	public WebElement topicName;
	
	@FindBy(name="addtopic")
	public WebElement add;
	
}
