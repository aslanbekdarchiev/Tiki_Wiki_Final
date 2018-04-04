package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
        	}

//ilyar's testing loginpage xpaths

	@FindBy(xpath="//*[@id=\"page-data\"]/p[4]/a")
	public WebElement tikiwiki;

	@FindBy(xpath="//input[@name='user']")
	public WebElement username;
	
	@FindBy(xpath="//input[@name='pass']")
	public WebElement password;
	@FindBy (xpath="//button[contains(text(), 'Log in')][@type='button']")
	public WebElement LogInDrowDown;
	@FindBy(xpath="//button[@class='btn btn-primary button submit']")
	public WebElement login;
	
	public void login(String userName, String pwd) {
		username.sendKeys(userName);
		password.sendKeys(pwd);
		login.click();
	}

}
