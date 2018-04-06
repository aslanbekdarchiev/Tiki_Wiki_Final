package com.app.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.app.pages.ListWikiPages;
import com.app.pages.MenuPage;
import com.app.pages.TikiSetupPage;
import com.app.pages.WikiPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CreateWikiPageStepDefs {

	private WebDriver driver = Driver.getDriver();

	//// div[@id='mod-menuleft1']/ul/li
	MenuPage menuPage = new MenuPage();
	TikiSetupPage tikiSetupPage = new TikiSetupPage();
	WikiPage wikiPage = new WikiPage();
	ListWikiPages listPages = new ListWikiPages();

	@Given("^I should see Menu options:$")
	public void i_should_see_Menu_options(List<String> menuOptions) {

		tikiSetupPage.goToControlPanel.click();

		for (int i = 0; i < menuPage.pageMenuOptions.size(); i++) {

			assertEquals(menuPage.pageMenuOptions.get(i).getText(), (menuOptions.get(i)));

		}

	}

	@Given("^I create wiki page \"([^\"]*)\"$")
	public void i_create_wiki_page(String nameOfThePage) {
		menuPage.wikiButton.click();
		BrowserUtils.waitForVisibility(menuPage.createWikiPage, 3);
		menuPage.createWikiPage.click();
		wikiPage.pagename.sendKeys(nameOfThePage);
		wikiPage.creeatePageButton.click();

		wikiPage.pageContent.sendKeys("Aika created the page Continous Integration");
		wikiPage.saveButton.click();

	}

	@Then("^Wiki Page \"([^\"]*)\"is listed in List Pages$")
	public void wiki_Page_is_listed_in_List_Pages(String arg1) {
		menuPage.wikiButton.click();
		BrowserUtils.waitForVisibility(menuPage.listPages, 3);
		menuPage.listPages.click();
		assertTrue(listPages.contIntPage.isDisplayed());
		assertTrue(listPages.contIntPage.getText().contains("Continuos"));
	}

	@Then("^I log out from application$")
	public void i_log_out_from_application() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", menuPage.logout);
		menuPage.logoutFinal.click();

	}

}
