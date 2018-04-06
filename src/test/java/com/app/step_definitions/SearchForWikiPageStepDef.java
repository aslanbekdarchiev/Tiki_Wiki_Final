package com.app.step_definitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.app.pages.ListWikiPages;
import com.app.pages.MenuPage;
import com.app.pages.TikiSetupPage;
import com.app.pages.WikiPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchForWikiPageStepDef {
	

	private WebDriver driver = Driver.getDriver();

	//// div[@id='mod-menuleft1']/ul/li
	MenuPage menuPage = new MenuPage();
	TikiSetupPage tikiSetupPage = new TikiSetupPage();
	WikiPage wikiPage = new WikiPage();
	ListWikiPages listPages = new ListWikiPages();
	
	
	@Given("^I go to List Pages$")
	public void i_go_to_List_Pages() {
		
		menuPage.wikiButton.click();
		BrowserUtils.waitForVisibility(menuPage.listPages, 3);
		menuPage.listPages.click();
	   
	}

	@Then("^I should  be able to search for \"([^\"]*)\" page$")
	public void i_should_be_able_to_search_for_page(String nameOfThePage) {
	   
		listPages.searchButton.sendKeys(nameOfThePage);
		listPages.findButton.click();
	}

	@Then("^the resulf of my search is the \"([^\"]*)\" page$")
	public void the_resulf_of_my_search_is_the_page(String nameOfThePage) {
	    assertTrue(driver.getTitle().contains(nameOfThePage));
	}
	

}
