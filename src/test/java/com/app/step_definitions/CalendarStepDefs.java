package com.app.step_definitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.app.pages.CalendarPage;
import com.app.pages.LoginPage;
import com.app.pages.MenuPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalendarStepDefs {
	private WebDriver driver = Driver.getDriver();
	MenuPage menuPage = new MenuPage();
	CalendarPage calendarPage = new CalendarPage();

	@When("^I click on the Create Calendar tab$")
	public void i_click_on_the_Create_Calendar_tab() {
		menuPage.calendarLink.click();
		calendarPage.addEventLink.click();

	}

	@When("^I enter the name \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_the_name_and(String Title, String Description) {

		Select hustler = new Select(calendarPage.dropDownHustler);
		hustler.selectByVisibleText("Hustlers21");
		calendarPage.title.sendKeys(Title);
		calendarPage.description.sendKeys(Description);
	}

	@When("^click on the save button$")
	public void click_on_the_save_button() {
		calendarPage.save.click();
	}

	@Then("^I should see calendars for \"([^\"]*)\"$")
	public void i_should_see_calendars_for(String Title) {
		
	calendarPage.listView.click();

		for (int i = calendarPage.hustlers21CalendarList.size()-1; i >=0; i--) {
			System.out.println(calendarPage.hustlers21CalendarList.get(i).getText());
			assertTrue(calendarPage.hustlers21CalendarList.get(i).getText().contains(Title));
			System.out.println(calendarPage.hustlers21CalendarList.get(i).getText());
			break;
		}
		
	}
}
