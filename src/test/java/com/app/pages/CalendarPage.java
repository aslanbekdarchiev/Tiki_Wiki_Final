package com.app.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class CalendarPage {

	private WebDriver driver;

	public CalendarPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Add Event")
	public WebElement addEventLink;
	
	@FindBy(name="save[name]")
	public WebElement title;
	@FindBy(name="save[description]")
	public WebElement description;
	@FindBy(name="act")
	public WebElement save;
	@FindBy(id="calid")
	public WebElement dropDownHustler;
	@FindBy(linkText="Admin")
	public WebElement adminLink;
	@FindBy(linkText="List View")
	public WebElement listView;
	@FindBy(xpath="//table[@class='table normal table-striped table-hover']//tr//td//a//*[@class='summary']")
	public List<WebElement> hustlers21CalendarList;
	@FindBy(xpath="//div[@class='modal-body']//*[contains(text(),'Hustlers21')]")
	public WebElement hustlerCalendar;
	@FindBy (xpath="//div[@class='calinput']//input[@value='Refresh']")
	public WebElement refresh;

}
