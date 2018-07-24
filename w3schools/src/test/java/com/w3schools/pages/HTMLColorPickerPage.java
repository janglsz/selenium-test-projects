package com.w3schools.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Class comprising of the locators and methods for testing the HTML Colour Picker page
 * 
 * @author Kevin Jang
 *
 */
public class HTMLColorPickerPage {
	
	// Objects
	WebDriver driver;
	WebDriverWait wait;
	
	// Locators
	By inputFieldColorValue = By.id("entercolor");
	By btnOK = By.className("btn");
	By labelHexValue = By.id("colorhexDIV");
	By hueLevel150 = By.xpath("(//td[contains(text(), '150')])[1]");
	By relatedHexValue = By.xpath("//td[contains(text(), '#00ff80')]"); 
	
	// Constructor
	public HTMLColorPickerPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void fillColorInputField(String rgbValue) {
		
		// Console Status Message
		System.out.println("Entering RGB value into the RGB input field...");
		
		// Wait for the colour input field to appear
		wait.until(ExpectedConditions.presenceOfElementLocated(inputFieldColorValue));
		
		// Click the colour input field
		driver.findElement(inputFieldColorValue).click();
		
		// Enter the RGB value into the colour input field
		driver.findElement(inputFieldColorValue).sendKeys(rgbValue);
	}

	
	public void clickOKBtn() {
		
		// Console Status Message
		System.out.println("Clicking the OK button...");
		
		// Wait until the button appears
		wait.until(ExpectedConditions.presenceOfElementLocated(btnOK));
		
		// Click the OK button
		driver.findElement(btnOK).click();
	}
	
	public void VerifyHexValue(String expectedHexVal) {
		
		// Wait for the Hex value to appear
		wait.until(ExpectedConditions.presenceOfElementLocated(labelHexValue));
		
		// Get the hex value
		String hexValue = driver.findElement(labelHexValue).getText();
		
		// Print the extracted hex value to the console
		System.out.println("Extracted Hex Value: " + hexValue);
		
		// Throw an assertion error if the hex value is not as expected
		Assert.assertEquals(hexValue, expectedHexVal);
	}
	
	public void verifyHueLevel(String expectedHueLevel) {
		
		// Wait for the "150" Hue level to appear
		wait.until(ExpectedConditions.presenceOfElementLocated(hueLevel150));
		
		// Find the "150" Hue level
		String actualHueLevel = driver.findElement(hueLevel150).getText();
		
		// Remove the trailing white space from the String
		actualHueLevel = actualHueLevel.trim();
		
		// Print the Hue level to the console
		System.out.println("Extracted Hue Level: " + actualHueLevel);
		
		// Throw an assert exception if the Hue level is not the expected value
		Assert.assertEquals(actualHueLevel, expectedHueLevel);
	}
	
	public void verifyHexValueFromSameHueLevelRow(String expectedHexValue) {
		
		// Wait for the hex value to appear
		wait.until(ExpectedConditions.presenceOfElementLocated(relatedHexValue));
		
		// Get the Hex value from the same row as the Hue Level in verifyHueLevel()
		String actualHexValue = driver.findElement(relatedHexValue).getText();
		
		// Print the extracted hex value to the console
		System.out.println("Extracted Hex Value From the Same Hue Level Row: " + actualHexValue);
		
		// Throw assert exception if the actual value is not the expected value
		Assert.assertEquals(actualHexValue, expectedHexValue);
		
	}
}
