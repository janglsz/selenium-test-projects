package com.samsung.account.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Kevin Jang
 * 
 * This method contain locators and methods for running tests on the login page
 *
 */
public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// Locators
	By signUpLink = By.xpath("/html/body[@class='iam-signinUI ng-scope block-ui block-ui-anim-fade']/div[@class='iam-wrapper']/main[@class='iam-main ng-scope']/div[@class='iam-main-inner']/div[@class='iam-contents']/div[@class='iam-signIn-link']/a[2]");
	
	// Constructor
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver = driver;
		this.wait = wait;
		
	}
	
	/**
	 * 	This method clicks the sign up link
	 * 
	 * @throws InterruptedException
	 */
	public void clickSignUpLink() throws InterruptedException {
		// Wait for the element to appear
		wait.until(ExpectedConditions.presenceOfElementLocated(signUpLink));
		
		Thread.sleep(1000);
		
		// Click the SignUp link
		driver.findElement(signUpLink).click();
	}

}
