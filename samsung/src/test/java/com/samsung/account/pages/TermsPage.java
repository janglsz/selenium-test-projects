package com.samsung.account.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TermsPage {

	WebDriver driver;
	WebDriverWait wait;
	
	// Locators
	By checkBoxTerms = By.id("iptTncTC");
	By checkBoxPrivacyPolicy = By.id("iptTncPP");
	By agreeButton = By.className("iam-primary");
	
	public TermsPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void selectTermsCheckBox() {
		wait.until(ExpectedConditions.presenceOfElementLocated(checkBoxTerms));
		driver.findElement(checkBoxTerms).click();
	}
	
	public void selectPrivacyPolicyCheckBox() {
		wait.until(ExpectedConditions.presenceOfElementLocated(checkBoxPrivacyPolicy));
		driver.findElement(checkBoxPrivacyPolicy).click();
	}
	
	public void clickAgreeButton() {
		wait.until(ExpectedConditions.presenceOfElementLocated(agreeButton));
		driver.findElement(agreeButton).click();
	}
}
