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

public class EditingWikiPageStepDefs {

	private WebDriver driver = Driver.getDriver();

	MenuPage menuPage = new MenuPage();
	TikiSetupPage tikiSetupPage = new TikiSetupPage();
	WikiPage wikiPage = new WikiPage();
	ListWikiPages listPages = new ListWikiPages();
	
	@Given("^I edit the page called \"([^\"]*)\"$")
	public void i_edit_the_page_called(String arg1) {
		
		menuPage.wikiButton.click();
		BrowserUtils.waitForVisibility(menuPage.listPages, 3);
		menuPage.listPages.click();
		listPages.contIntPage.click();
		listPages.editButton.click();
		wikiPage.pageContent.sendKeys("Aika is editing the page ");
		wikiPage.saveButton.click();
		
		
		
		
		
	    
	}

	@Then("^I am able to see Last Changes of this pages$")
	public void i_am_able_to_see_Last_Changes_of_this_pages() {
		menuPage.wikiButton.click();
		BrowserUtils.waitForVisibility(menuPage.lastChanges, 3);
		menuPage.lastChanges.click();
		assertTrue(listPages.updatedStatus.isDisplayed());
		
	   
	}
	

}
