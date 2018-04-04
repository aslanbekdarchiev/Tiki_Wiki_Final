package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class MenuPage {

	private WebDriver driver;

	public MenuPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
}
