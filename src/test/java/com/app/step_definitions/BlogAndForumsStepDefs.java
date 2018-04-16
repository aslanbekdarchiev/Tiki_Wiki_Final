package com.app.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.app.pages.CreateBlogPage;
import com.app.pages.MenuPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BlogAndForumsStepDefs {

	private WebDriver driver = Driver.getDriver();

	MenuPage menuPage = new MenuPage();
	CreateBlogPage blogPage = new CreateBlogPage();

	// blogs step definition
	@When("^I am on the Home page$")
	public void i_am_on_the_Home_page() {
		System.out.println(driver.getTitle());
		// assertEquals(driver.getTitle(), "Home Page | HomePage");

	}

	@When("^I click on Blogs button$")
	public void i_click_on_Blogs_button() {
		menuPage.blogsDropDown.click();
		BrowserUtils.waitFor(3);
	}

	@Then("^I should see Pages option:$")
	public void i_should_see_Pages_option(List<String> options) {
		for (int i = 0; i < options.size(); i++) {
			assertEquals(menuPage.blogsDropDownList.get(i).getText(), options.get(i));
			System.out.println(menuPage.blogsDropDownList.get(i).getText());
		}
	}

	@Then("^I create new blog with \"([^\"])\" and \"([^\"])\"$")
	public void i_create_new_blog_with_and(String title, String description) {
		menuPage.createBlog.click();
		BrowserUtils.waitForVisibility(blogPage.title, 5);
		blogPage.title.click();
		blogPage.title.sendKeys(title);
		BrowserUtils.waitForVisibility(blogPage.description, 5);
		blogPage.description.click();
		blogPage.description.sendKeys(description);
		blogPage.save.click();

		BrowserUtils.waitFor(5);
	}

	@Then("^I should see \"([^\"])\"  with \"([^\"])\" in blogs list$")
	public void i_should_see_with_in_blogs_list(String title, String description) {

		for (int i = 0; i < blogPage.createdBlogsTitleList.size(); i += 7) {
			assertTrue(blogPage.createdBlogsTitleList.get(i).getText().contains(title));
			System.out.println(blogPage.createdBlogsTitleList.get(i).getText());
			assertTrue(blogPage.createdBlogsDescriptionList.get(i).getText().contains(description));
			System.out.println(blogPage.createdBlogsDescriptionList.get(i).getText());
			break;
		}
}
}