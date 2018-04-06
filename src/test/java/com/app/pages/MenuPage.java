package com.app.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class MenuPage {


	private WebDriver driver;


	public MenuPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//ul[@id='menu_option51']/..")
	public WebElement articlesDropDown;
	
	@FindBy(xpath="//ul[@id='menu_option51']//li[3]")
	public WebElement newArticleFromArticleDropDown;
	
	@FindBy(xpath="//ul[@id='menu_option51']//li[2]")
	public WebElement listArticleFromArticleDropDown;
	
	@FindBy(xpath="//ul[@id='menu_option51']//li[4]")
	public WebElement adminTopicsFromArticleDropDown;

	
	@FindBy(xpath="//div[@id='mod-menuleft1']/ul/li")
	public List <WebElement>pageMenuOptions;
	
	
	@FindBy(xpath="//div[@id='mod-menuleft1']//li/a[@href='#menu_option32']")
	public WebElement wikiButton;
	
	@FindBy(xpath="//a[contains(text(),' Create a Wiki Page')]")
	public WebElement createWikiPage;
	
	@FindBy(xpath="//a[contains(text(),' List Pages')]")
	public WebElement listPages;
	
	@FindBy(xpath="//a[contains(text(),' Last Changes')]")
	public WebElement lastChanges;
	
	@FindBy(xpath="//button[@class='dropdown-toggle login_link btn btn-link']")
	public WebElement logout;
	
	@FindBy(xpath="//a[@title='Log out']")
	public WebElement logoutFinal;

	
	
}
