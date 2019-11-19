package com.atmecs.konakart.testscripts;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.atmecs.konakart.testbase.InvokeBrowser;
import com.atmecs.konakart.utils.PageActions;
import com.atmecs.konakart.utils.ValidateTestResult;

public class PriceValidation extends InvokeBrowser {
	@Test(priority = 2)
	public void clickOnHeaders() {
		Xpath = read.readPropertiesFile("loc.headers.computerperipherals.xpath");
		PageActions.clickOnElement(driver, Xpath);
	}

	@Test(priority = 5)
	public void slider() {
		int x = 10;
		Xpath = read.readPropertiesFile("(loc.slider.move.xpath");
		WebElement slider = driver.findElement(By.xpath("//div[@id='price-range-slider']"));
		int width = slider.getSize().getWidth();
		Actions move = new Actions(driver);
		move.moveToElement(slider, ((width * x) / 10), 0).click();
		move.build().perform();
		System.out.println("Slider moved");
	}

	@Test(priority = 6)
	public void validateproduct() {
		Xpath = read.readPropertiesFile("loc.bundlesaver.xpath");
		String actualproduct = driver.findElement(By.xpath(Xpath)).getText();
		String expectedproduct = "Bundle Saver";
		ValidateTestResult.validateData(actualproduct, expectedproduct, "actual not equal to expected");
		log.info("Successfully validated product");
	}

}
