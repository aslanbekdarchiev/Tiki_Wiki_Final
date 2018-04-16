package com.app.step_definitions;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.app.pages.CreateArticlePage;
import com.app.pages.MenuPage;
import com.app.pages.TopicsPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TopicsStepDefs {
	MenuPage menu=new MenuPage();
	TopicsPage topicPage=new TopicsPage();
	WebDriver driver=Driver.getDriver();
	CreateArticlePage createArticle=new CreateArticlePage();
	@When("^I create topic \"([^\"]*)\"$")
	public void i_create_topic(String topic) {
		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.adminTopicsFromArticleDropDown, 3).click();
		topicPage.topicName.sendKeys(topic);
		topicPage.add.click();
	}

	@Then("^\"([^\"]*)\" topic must be in topic list$")
	public void topic_must_be_in_topic_list(String topic) {
		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.adminTopicsFromArticleDropDown, 3).click();
		
	    List<WebElement>list=driver.findElements(By.xpath("//*[contains(text(),'"+topic+"')]/../.."));
		System.out.println(list.size());
	    assertTrue(list.size()>0);
		
	}

	@Then("^\"([^\"]*)\" must be in articles topic list$")
	public void must_be_in_articles_topic_list(String topic) {
		menu.articlesDropDown.click();
		BrowserUtils.waitForVisibility(menu.newArticleFromArticleDropDown, 3).click();
		createArticle.classification.click();
		
		boolean flag=false;
		for(WebElement elem:createArticle.topicDropDown) {
			if(elem.getText().equals(topic))
				flag=true;
		}
		assertTrue(flag);
	}
}
