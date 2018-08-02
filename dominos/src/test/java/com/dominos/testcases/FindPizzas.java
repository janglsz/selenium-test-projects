package com.dominos.testcases;

import org.testng.annotations.Test;
import com.dominos.pages.MenuPage;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;


/**
 * This class contains test cases to find pizza's on the dominos website
 * 
 * @author Kevin Jang
 *
 */
public class FindPizzas {
	
	// CONSTANTS
	final int WAIT_TIME = 30;
	
	// OBJECTS
	WebDriver driver;
	WebDriverWait wait;
	
	public String baseURL;
	public String expectedPizza;
	public String expectedkJValue;
	
	
	@BeforeTest
	public void beforeTest() {
				
		// Launch Firefox
		driver = new FirefoxDriver();
		
		// Set the WebDriver wait time
		wait = new WebDriverWait(driver, WAIT_TIME);
		
		// Set the baseURL
		baseURL = "https://www.dominos.com.au/menu";
		
		// Launch the web page
		driver.get(baseURL);
	}
  
	@Test
	public void findPizzas() {
		
		// Create the MenuPage object
		MenuPage menuPage = new MenuPage(driver, wait);
		
		// Find the "HAWAIIAN" pizza
		menuPage.findHawaiianPizza("HAWAIIAN");
		
		// Verify the kJ value for the "HAWAIIAN" pizza is 4912kJ^
		menuPage.findHawaiianKJValue("4912kJ^");
		
		// Find the "4032kJ^" value 
		menuPage.findHamAndCheeseKJValue("4032kJ^");
		
		// Find the "HAM & CHEESE" pizza
		menuPage.findHamAndCheesePizza("HAM & CHEESE");
	}

	@AfterTest
	public void afterTest() {
		
		// Exit Firefox
		driver.quit();
		
	}

}
