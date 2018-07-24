package com.dominos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MenuPage {
	
	//Objects
	String actualString;
	
	WebDriver driver;
	WebDriverWait wait;
		
	// Locators
	By hawaiianText = By.xpath("//SPAN[@class='menu-entry'][text()='Hawaiian ']");
	By hawaiiankJText = By.xpath("(//div[contains(text(), '4912kJ^')])[1]");
	By hamdAndCheesekJText = By.xpath("//div[contains(text(), '4032kJ^')]");
	By hamAndCheeseText = By.xpath("//span[contains(text(), 'Ham & Cheese')]");
	
	// Constructor
	public MenuPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	/**
	 * This method checks if the "HAWAIIAN" pizza appears on the page
	 * 
	 * @param expectedPizzaName	The pizza expected pizza name that should be found on the page
	 */
	public void findHawaiianPizza(String expectedPizzaName) {
		
		// Wait until the element loads
		wait.until(ExpectedConditions.presenceOfElementLocated(hawaiianText));
		
		// Extract the text
		actualString = driver.findElement(hawaiianText).getText();
		
		// Print the extracted text to the console
		System.out.println("Extracted Pizza Name: " + actualString);
		
		// If the actual text does not match the expected text, throw an assertion error
		Assert.assertEquals(actualString, expectedPizzaName);
	}
	
	/**
	 * This method checks that the "HAWAIIAN" pizza kJ value is correct
	 * 
	 * @param expectedkJValue	The expected kJ value of the "HAWAIIAN" pizza
	 */
	public void findHawaiianKJValue(String expectedkJValue) {
		
		// Wait of the KJ text to appear
		wait.until(ExpectedConditions.presenceOfElementLocated(hawaiiankJText));
		
		// Extract the text
		actualString = driver.findElement(hawaiiankJText).getText();
		
		// Print the extracted text to the console
		System.out.println("Extracted KJ Value is: " + actualString);
		
		// If the actual text does not match the expected text, throw an assertion error
		Assert.assertEquals(actualString, expectedkJValue);
	}
	
	
	/**
	 * This method verifies that there is a "4032kJ^" value on the page
	 * 
	 * @param expectedkJValue	The expected String to compare the extracted text with
	 */
	public void findHamAndCheeseKJValue(String expectedkJValue) {
		
		// Wait for the kJ value to appear
		wait.until(ExpectedConditions.presenceOfElementLocated(hamdAndCheesekJText));
		
		// Get the text from the element
		actualString = driver.findElement(hamdAndCheesekJText).getText();
		
		// Print the extracted text to the console
		System.out.println("Extracted Ham & Cheese kJ Value: " + actualString);
		
		// If the actual text does not match the expected text, throw an assertion error
		Assert.assertEquals(actualString, expectedkJValue);
	}
	
	
	/**
	 * 	This method verifies that the name of the "4032kJ^" pizza is "HAM & CHEESE"
	 * 
	 * @param expectedValue	The expected String to compare the extracted text with
	 */
	public void findHamAndCheesePizza(String expectedValue) {
		
		// Wait for the "HAM & CHEESE" to appear
		wait.until(ExpectedConditions.presenceOfElementLocated(hamAndCheeseText));
		
		// Get the text
		actualString = driver.findElement(hamAndCheeseText).getText();
		
		// Print the extracted text to the console
		System.out.println("Extracted Text: " + actualString);
		
		// If the actual text does not match the expected text, throw an assertion error
		Assert.assertEquals(actualString, expectedValue);
	}
	
	
	
}
