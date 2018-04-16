package com.app.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class MenuPage {

	//comment
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
		public List <WebElement> pageMenuOptions;
		
		
		@FindBy(xpath="(//div[@id='mod-menuleft1']//a)[6]")
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
		
		//Hikmet
		@FindBy(xpath = "//a[@href='#']//span[@class='icon icon-history glyphicon glyphicon-time ']")
		public WebElement clock;

		@FindBy(xpath = "//a[@href='#']//span[@class='icon icon-menu-extra glyphicon glyphicon-chevron-down ']")
		public WebElement angleDown;
		
		@FindBy (linkText="Calendar")
		public WebElement calendarLink;
		
		@FindBy(linkText="Forums")
		public WebElement forumsDropDown;
		
		@FindBy(linkText="Blogs")
		public WebElement blogsDropDown;
		@FindBy(linkText="Create Blog")  //ul[@id=\"menu_option266\"]//li[2]
		public WebElement createBlog;
		@FindBy(linkText="Admin Forums")
		public WebElement adminForumsLink;

		@FindBy (xpath = "//li//ul[@id='menu_option266']//li")
		public List<WebElement> blogsDropDownList;
		@FindBy (xpath = "//li//ul[@id='menu_option272']//li")
		public List<WebElement> forumsDropDownList;
		


		public List<WebElement> adminOptions(String name) {

			if (name.equals("Recent Preferences")) {
				String xpath = "//span[@class='icon icon-history glyphicon glyphicon-time ']/../..//li/a";
				return driver.findElements(By.xpath(xpath));
			} else if (name.equals("Quick Administration")) {
				String xpath = "//span[@class='icon icon-menu-extra glyphicon glyphicon-chevron-down ']/../..//li/a";
				return driver.findElements(By.xpath(xpath));
			}
			return null;
		}

		
		
	}