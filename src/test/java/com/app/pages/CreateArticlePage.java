package com.app.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class CreateArticlePage {
	private WebDriver driver;

	public CreateArticlePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"content_edit_article1-2\"]/div[1]/div/select/option")
	public List<WebElement> topicDropDown;

	@FindBy(linkText = "Classification")
	public WebElement classification;

	@FindBy(name = "title")
	public WebElement titleInput;

	@FindBy(name = "heading")
	public WebElement headingInput;

	@FindBy(name = "body")
	public WebElement bodyInput;

	@FindBy(name = "save")
	public WebElement save;

	@FindBy(linkText = "New Article")
	public WebElement newArticle;

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
