package com.atmecs.konakart.testscripts;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.atmecs.konakart.testbase.InvokeBrowser;
import com.atmecs.konakart.utils.PageActions;
import com.atmecs.konakart.utils.ValidateTestResult;

public class ProductSelectPage extends InvokeBrowser {
	SearchPage search = new SearchPage();

	@Test(priority = 2)
	public void selectProductFromDropdown() {
		Xpath = read.readPropertiesFile("loc.select.computerperipherals.xpath");
		PageActions.clickOnElement(driver, Xpath);
		Xpath = read.readPropertiesFile("loc.hitonsearch.xpath");
		PageActions.clickOnElement(driver, Xpath);
	}

	@Test(priority = 3)
	public void enterData() {
		Xpath = read.readPropertiesFile("loc.clicktextfield.xpath");
		driver.findElement(By.xpath(Xpath)).sendKeys("graphics cards");
		log.info("Entered as Graphics cards");
	}

	@Test(priority = 4)
	public void hitSearch() {
		Xpath = read.readPropertiesFile("loc.hitonsearch.xpath");
		PageActions.clickOnElement(driver, Xpath);
	}

	@Test(priority = 5)
	public void validateOutcomeNotByDropdown() {
		Xpath = read.readPropertiesFile("loc.validate.outcome.notselectedfromdropdown.xpath");
		WebElement outcome = driver.findElement(By.xpath(Xpath));
		ValidateTestResult.validateData(outcome, "outcomevalue", "No match found");
	}

	@Test(priority = 6)
	public void enterValue() {
		Xpath = read.readPropertiesFile("loc.clicktextfield.xpath");
		PageActions.clickOnElement(driver, Xpath);
		driver.findElement(By.xpath(Xpath)).sendKeys("graphics cards");
		Xpath = read.readPropertiesFile("loc.selectgraphicscards.xpath");
		PageActions.clickOnElement(driver, Xpath);
	}

	@Test(priority = 7)
	public void validateOutcomeByDropdown() {
		Xpath = read.readPropertiesFile("loc.noofitems.outcome.xpath");
		String outcomebydopdown = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(outcomebydopdown, "OutComeBydropdown", "No match");
	}
}
