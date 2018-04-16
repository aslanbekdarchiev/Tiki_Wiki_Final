package com.app.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class CreateForumPage {
	private WebDriver driver;

	public CreateForumPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText="Create/Edit Forums")
	public WebElement createForumTab;
	@FindBy(xpath ="//*[@name='name']")
	public WebElement name;
	
	@FindBy(id ="description")
	public WebElement description;
	@FindBy(name ="save")
	public WebElement save;
	
	@FindBy (xpath="//table[@id='forums1']//tr//td//a")
	public List<WebElement> createdForumsNameList;
	
	@FindBy (xpath="//table[@id='forums1']//tr//td//div")
	public List<WebElement> createdForumsDescriptionList;
	
	
}

