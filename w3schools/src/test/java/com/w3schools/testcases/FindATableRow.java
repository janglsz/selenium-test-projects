package com.w3schools.testcases;

import org.testng.annotations.Test;

import com.w3schools.pages.HTMLColorPickerPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

/**
 * Test case for finding and verifying values in a table
 * 
 * @author Kevin Jang
 *
 */
public class FindATableRow {
	
	// CONSTANTS
	public static final String BASE_URL = "https://www.w3schools.com/colors/colors_picker.asp";
	public static final int WAIT_TIME = 10;
	
	// OBJECTS
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void beforeTest() {
		
		// Tell the system where to find Firefox geckodriver.exe
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\GeckoDriver\\geckodriver.exe");
		
		// Launch Firefox
		driver = new FirefoxDriver();
		
		// Maximise the Firefox window
		driver.manage().window().maximize();
		
		// Set the WebDriverWait time
		wait = new WebDriverWait(driver, WAIT_TIME);
		
		// Go to the baseURL page
		driver.get(BASE_URL);
	}
  
	@Test
	public void VerifyTableValues() {
		
		// Create the HTMLColorPickerPage object
		HTMLColorPickerPage colorPickerPage = new HTMLColorPickerPage(driver, wait);
		
		// Enter the RGB value
		colorPickerPage.fillColorInputField("rgb(0,0,255)");
		
		// Click the OK button
		colorPickerPage.clickOKBtn();
		
		// Verify that RGB value
		colorPickerPage.VerifyHexValue("#0000ff");
		
		// Find the Hue level
		colorPickerPage.verifyHueLevel("150");
		
		colorPickerPage.verifyHexValueFromSameHueLevelRow("#00ff80");
	}

	@AfterTest
 	public void afterTest() {
		
		// Quit Firefox
		driver.quit();
	}
}
