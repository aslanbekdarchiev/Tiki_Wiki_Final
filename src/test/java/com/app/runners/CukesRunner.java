package com.app.runners;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "pretty",
		"html:target/cucumber-report" }, 

tags = "@aika", 
features = "src/test/resources/com/app/features/", 
glue = "com/app/step_definitions/",
dryRun = false)

public class CukesRunner extends AbstractTestNGCucumberTests {
	
}

