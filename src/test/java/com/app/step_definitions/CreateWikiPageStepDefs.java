package com.app.step_definitions;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CreateWikiPageStepDefs {
	
	////div[@id='mod-menuleft1']/ul/li
	
	@Given("^I should see Menu options:$")
	public void i_should_see_Menu_options(ArrayList<WebElement>menuOptions) {
		
		
	    
	}

	@Given("^I create wiki page \"([^\"]*)\"$")
	public void i_create_wiki_page(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Wiki Page \"([^\"]*)\"is listed in List Pages$")
	public void wiki_Page_is_listed_in_List_Pages(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	

}
