package com.app.step_definitions;

import static org.testng.Assert.assertEquals;

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
		loginPage.goToControlPanel.click();
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
		List<WebElement> listOfTitltes = driver
				.findElements(By.xpath("//*[contains(text(), '" + title + "')]/../../td[1]"));
		
		listArticles.deleteArticleByTitleName(title);

	}


	@Then("^(.*) must not be in article list$")
	public void must_not_be_in_article_list(String title) {
		List<WebElement> listOfTitltes = driver
				.findElements(By.xpath("//*[contains(text(), '" + title + "')]/../../td[1]"));
		
		assertEquals( listOfTitltes.size(),0,"All "+title+" aritlces are removed from list");
	}

	@Then("^I logout from tiki-wiki$")
	public void i_logout_from_tiki_wiki() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", loginPage.logOutDropDown);
		
		loginPage.logOutFromDropDown.click();
	}
	
	@When("^I create article with (.*) title$")
	public void i_create_article_with_title(String title) {
		loginPage.goToControlPanel.click();
		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.newArticleFromArticleDropDown, 3).click();
		createArticle.createArticle(title, null, null);
	}

}
