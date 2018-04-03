package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
        	}

//ilyar's testing loginpage xpaths



}
