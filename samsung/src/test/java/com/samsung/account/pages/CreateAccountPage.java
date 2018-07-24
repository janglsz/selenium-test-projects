package com.samsung.account.pages;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// Locators
	By emailField = By.id("signUpID");
	By passwordField = By.id("password");
	By confirmPasswordField = By.id("confirmPassword");
	By firstNameField = By.id("givenName1");
	By passwordMismatchErrorText = By.id("cpwError2");
	
	public CreateAccountPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void enterEmail(String email) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
		Thread.sleep(2000);
		driver.findElement(emailField).click();
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
		driver.findElement(passwordField).click();
		driver.findElement(passwordField).sendKeys(pwd);
	}

	public void confirmPassword(String confirmPwd) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(confirmPasswordField));
		Thread.sleep(2000);
		driver.findElement(confirmPasswordField).click();
		driver.findElement(confirmPasswordField).sendKeys(confirmPwd);
	}
	
	public void clickFirstNameField() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(firstNameField));
		Thread.sleep(2000);
		driver.findElement(firstNameField).click();
	}
	
	public void checkPasswordErrorMsg(String expectedErrorMessage) {
		wait.until(ExpectedConditions.presenceOfElementLocated(passwordMismatchErrorText));
		String errorMessage = driver.findElement(passwordMismatchErrorText).getText();
		
		System.out.println("errorMessage: " + errorMessage);
		System.out.println("expectedErrorMessage: " + expectedErrorMessage);
		
		// Check if the expected String appears
		if (Objects.equals(errorMessage, expectedErrorMessage)) {
			System.out.println("The correct Password error message has appeared: " + errorMessage);
		} else {
			System.out.println("The incorrect error message appeared: " + errorMessage);
		}
	}
	
}
