package com.app.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

public class ListArticlesPage {
	WebDriver driver;

	public ListArticlesPage() {
		driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='submit_mult']")
	public WebElement selectAction;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	public WebElement OK;

	@FindBy(linkText = "Confirm action")
	public WebElement confirmAction;

	@FindBy(xpath = "//*[@id=\"col1\"]/a[1]")
	public WebElement goBack;

	public void deleteArticleByTitleName(String title) {
		List<WebElement> listOfTitltes = driver
				.findElements(By.xpath("//*[contains(text(), '" + title + "')]/../../td[1]"));

		int before = listOfTitltes.size();
		if (before > 0) {
			for (int i = 0; i < before; i++)
				listOfTitltes.get(i).click();
			Select select = new Select(selectAction);
			select.selectByValue("remove_articles");
			OK.click();
			BrowserUtils.waitForVisibility(confirmAction, 3);
			confirmAction.click();
			try {
				goBack.click();
				BrowserUtils.waitForVisibility(confirmAction, 3);
				confirmAction.click();

			} catch (Exception e) {

			}
			BrowserUtils.waitForPageToLoad(3);
			listOfTitltes = driver.findElements(By.xpath("//*[contains(text(), '" + title + "')]/../../td[1]"));
			assertEquals(0, listOfTitltes.size());
		} else {
			System.out.println("no expected articles present in list, or check title name");
		}
	}

}
