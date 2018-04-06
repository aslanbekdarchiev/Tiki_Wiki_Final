package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class TikiSetupPage {
	private WebDriver driver;

	public TikiSetupPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	

@FindBy(xpath="//a[@class='btn btn-default ']")
public WebElement goToControlPanel;

}
