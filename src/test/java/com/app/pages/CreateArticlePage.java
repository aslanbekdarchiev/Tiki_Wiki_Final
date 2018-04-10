package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;
//hikmet
public class CreateArticlePage {
	WebDriver driver;

	public CreateArticlePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(name = "title")
	public WebElement titleInput;

	@FindBy(name = "heading")
	public WebElement headingInput;

	@FindBy(name = "body")
	public WebElement bodyInput;

	@FindBy(name = "save")
	public WebElement save;

	public void createArticle(String title, String body, String heading) {

		try {
			titleInput.sendKeys(title);

		} catch (Exception e) {
			System.out.println("No title");
		}

		try {
			bodyInput.sendKeys(body);

		} catch (Exception e) {
			System.out.println("No body");
		}

		try {
			headingInput.sendKeys(heading);

		} catch (Exception e) {
			System.out.println("No heading");
		}
		save.click();
	}

}
