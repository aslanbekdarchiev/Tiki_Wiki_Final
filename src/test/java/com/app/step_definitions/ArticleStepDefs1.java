package com.app.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.app.pages.CreateArticlePage;
import com.app.pages.ListArticlesPage;
import com.app.pages.LoginPage;
import com.app.pages.MenuPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ArticleStepDefs1 {
	LoginPage loginPage = new LoginPage();
	MenuPage menu = new MenuPage();
	CreateArticlePage createArticle = new CreateArticlePage();
	WebDriver driver = Driver.getDriver();
	ListArticlesPage listArticles = new ListArticlesPage();

	int listWhenArticleCreated;
	int listWhenArticleDeleted;

	@When("^I create article without content$")
	public void i_create_article_without_content() {
		BrowserUtils.waitForPageToLoad(3);// loginPage.goToControlPanel.click();
		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.newArticleFromArticleDropDown, 3).click();
		createArticle.createArticle(null, null, null);

	}

	@Then("^(.*) article must be in articles list$")
	public void article_must_be_in_articles_list(String noTitleSpecified) {
		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.listArticleFromArticleDropDown, 3).click();
		assertEquals(noTitleSpecified, driver.findElement(By.linkText(noTitleSpecified)).getText());
	}

	@Then("^I delete (.*) article$")
	public void i_delete_article(String title) {
		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.listArticleFromArticleDropDown, 3).click();

		listArticles.deleteArticleByTitleName(title);

	}
	@When("^I create  article with \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_create_article_with_and(String title, String body, String heading) {
		BrowserUtils.waitForPageToLoad(3);
		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.newArticleFromArticleDropDown, 3).click();
		createArticle.createArticle(title, body, heading);
	}

	@Then("^I verify  article \"([^\"]*)\" has \"([^\"]*)\" and \"([^\"]*)\" content$")
	public void i_verify_article_has_and_content(String title, String body, String heading) {
		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.listArticleFromArticleDropDown, 3).click();
		List<WebElement> list = driver.findElements(By.linkText(title));

		try {
			list.get(0).click();
			assertEquals(listArticles.articleTitle.getText(),title);
			assertEquals(listArticles.articleHeading.getText(),heading);
			assertEquals(listArticles.articleBody.getText(),body);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("^(.*) must not be in article list$")
	public void must_not_be_in_article_list(String title) {
		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.listArticleFromArticleDropDown, 3).click();
		List<WebElement> listOfTitltes = driver
				.findElements(By.xpath("//*[contains(text(), '" + title + "')]/../../td[1]"));

		assertEquals(listOfTitltes.size(), 0, "All " + title + " aritlces are removed from list");

	}

	@When("^I create article with (.*) title$")
	public void i_create_article_with_title(String title) {

		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.newArticleFromArticleDropDown, 3).click();
		createArticle.createArticle(title, null, null);
	}

	@When("^I create article \"([^\"]*)\" write \"([^\"]*)\" in bold text format$")
	public void i_create_article_write_in_bold_text_format(String title, String heading) {
		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.newArticleFromArticleDropDown, 3).click();
		createArticle.createArticle(title, null, heading);

	}

	@Then("^\"([^\"]*)\" articles  body bust be bold text format$")
	public void articles_body_bust_be_bold_text_format(String title) {
		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.listArticleFromArticleDropDown, 3).click();
		List<WebElement> list = driver.findElements(By.linkText(title));

		try {
			list.get(0).click();
			assertTrue(driver.findElement(By.tagName("strong")).isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
