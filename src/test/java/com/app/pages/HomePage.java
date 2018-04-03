package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class HomePage {
	private WebDriver driver;

	public HomePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	//something for Aika
	//login button on the main home page
	@FindBy(xpath="//*[@data-toggle='dropdown']") //*[@id="mod-login_boxtop2"]/div/button
	WebElement LogInButton;
	
}
