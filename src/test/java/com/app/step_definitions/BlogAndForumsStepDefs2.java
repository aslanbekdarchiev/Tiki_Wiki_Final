package com.app.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.app.pages.CreateForumPage;
import com.app.pages.MenuPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BlogAndForumsStepDefs2 {
	private WebDriver driver = Driver.getDriver();

	MenuPage menuPage = new MenuPage();
	CreateForumPage forumPage = new CreateForumPage();
	
	
	@When("^I click on Forum button$")
	public void i_click_on_Forum_button() {
	   menuPage.forumsDropDown.click();
	}

	@Then("^I should see Forum option:$")
	public void i_should_see_Forum_option(List<String> options) {
		for (int i = 0; i < options.size(); i++) {
			assertEquals(menuPage.forumsDropDownList.get(i).getText(), options.get(i));
			System.out.println(menuPage.forumsDropDownList.get(i).getText());
		}
	}
	
	@Then("^I create new form with \"([^\"])\" and \"([^\"])\"$")
	public void i_create_new_form_with_and(String Name, String Description) {
		menuPage.adminForumsLink.click();
		
		forumPage.createForumTab.click();
		forumPage.name.click();
		forumPage.name.sendKeys(Name);
		BrowserUtils.waitForVisibility(forumPage.description, 5);
		forumPage.description.click();
		forumPage.description.sendKeys(Description);
		forumPage.save.click();

		BrowserUtils.waitFor(5);
	}

	@Then("^I should see \"([^\"])\"  with \"([^\"])\" in blogs list:$")
	public void i_should_see_with_in_blogs_list(String Name, String Description) {
		for (int i = 0; i < forumPage.createdForumsNameList.size(); i += 3) {
			assertTrue(forumPage.createdForumsNameList.get(i).getText().contains(Name));
			System.out.println(forumPage.createdForumsNameList.get(i).getText());
			assertTrue(forumPage.createdForumsDescriptionList.get(i).getText().contains(Description));
			System.out.println(forumPage.createdForumsDescriptionList.get(i).getText());
			break;
		}
	   
	}
}

