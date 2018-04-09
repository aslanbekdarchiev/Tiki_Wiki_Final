package com.app.step_definitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.app.pages.LoginPage;
import com.app.pages.MenuPage;
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
	MenuPage dashboard = new MenuPage();

	@Given("^I logged into tiki-wiki$")
	public void i_logged_into_tiki_wiki() {
		driver.get(ConfigurationReader.getProperty("url"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginPage.LogInDrowDown);
		loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
		BrowserUtils.waitFor(5);
	}

	@When("^I hover over the (clock|angle-down) icon$")
	public void i_hover_over_the_clock_icon(String menu) {

		switch (menu) {
		case "clock":
			dashboard.clock.click();
			break;
		case "angle-down":
			dashboard.angleDown.click();
			break;
		}
	}

	@Then("^following options should be visible for (Recent Preferences|Quick Administration):$")
	public void following_options_should_be_visible_for_Recent_Preferences(String menu, List<String> options) {
		// capture list of web elements
		List<WebElement> topAdminOptions = dashboard.adminOptions(menu);

		// get their text in a list
		List<String> topAdminOptionsString = BrowserUtils.getElementsText(topAdminOptions);

		for (int i = 0; i < options.size(); i++) {
			assertEquals(topAdminOptionsString.get(i), options.get(i));
		}

	}
	@Then("^I logout from tiki-wiki$")
	public void i_logout_from_tiki_wiki() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", loginPage.logOutDropDown);

		loginPage.logOutFromDropDown.click();
	}

}