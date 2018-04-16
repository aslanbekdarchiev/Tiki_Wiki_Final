package com.app.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class CreateBlogPage {
	private WebDriver driver;

	public CreateBlogPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
        	}
	
	
	@FindBy(xpath ="//*[@name='title']")
	public WebElement title;
	
	@FindBy(id ="blog-desc")
	public WebElement description;
	
	@FindBy (name ="save")
	public WebElement save;
	
	@FindBy (xpath="//table[@class='table table-striped normal']//tr//td//a")
	public List<WebElement> createdBlogsTitleList;
	
	@FindBy (xpath="//table[@class='table table-striped normal']//tr//td//div")
	public List<WebElement> createdBlogsDescriptionList;
}

