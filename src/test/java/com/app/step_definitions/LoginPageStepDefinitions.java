package com.app.step_definitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.app.pages.LoginPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageStepDefinitions {
	private WebDriver driver = Driver.getDriver();
	LoginPage loginPage = new LoginPage();

	@Given("^I logged into tiki-wiki$")
	public void i_logged_into_tiki_wiki() {
		driver.get(ConfigurationReader.getProperty("url"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginPage.LogInDrowDown);
		
		loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
	

	}

	@When("^I hover over the clock icon$")
	public void i_hover_over_the_clock_icon() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^following options should be visible for Recent Preferences:$")
	public void following_options_should_be_visible_for_Recent_Preferences(DataTable arg1) {

	}

	@When("^I hover over the angle-down icon$")
	public void i_hover_over_the_angle_down_icon() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^following options should be visible for Quick Administration:$")
	public void following_options_should_be_visible_for_Quick_Administration(DataTable arg1) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc).
		// Field names for YourType must match the column names in
		// your feature file (except for spaces and capitalization).

	}

}
