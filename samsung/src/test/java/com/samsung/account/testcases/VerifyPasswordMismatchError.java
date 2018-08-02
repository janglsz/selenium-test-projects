package com.samsung.account.testcases;

import org.testng.annotations.Test;

import com.samsung.account.pages.CreateAccountPage;
import com.samsung.account.pages.LoginPage;
import com.samsung.account.pages.TermsPage;
import com.samsung.account.utilities.ReadExcel;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

/**
 * 
 * @author Kevin Jang
 * 
 * This class contains the test case for verifying the presence of the password mismatch error
 *
 */
public class VerifyPasswordMismatchError {
	
	final int WAIT_TIME = 30;
	String baseURL = "https://account.samsung.com/membership/service/getServieInfoList.do";
	
	WebDriver driver;
	WebDriverWait wait;
	
	public String email;
	public String correctPassword;
	public String incorrectPassword;
	public String expectedPwdErrorMsg;
	
	@BeforeTest
	public void beforeTest() {
		
		// Launch Firefox
		driver = new FirefoxDriver();
		
		// Set the wait time for an element to load
		wait = new WebDriverWait(driver, WAIT_TIME);
		
		// Maximise the page
		driver.manage().window().maximize();
		
		// Go to the base URL
		driver.get(baseURL);
		
		// Get the Excel File with the user account information
		ReadExcel excelFile = new ReadExcel("src\\test\\resources\\Test_Data.xlsx", "Sheet1" );
		
		email = excelFile.getStringData(1, 0);
		correctPassword = excelFile.getStringData(1, 1);
		incorrectPassword = excelFile.getStringData(1, 2);
		expectedPwdErrorMsg = excelFile.getStringData(1, 3);
	}
	
	@Test
	public void VerifyErrorMessageAppears() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver, wait);
		loginPage.clickSignUpLink();
		
		TermsPage termspage = new TermsPage(driver, wait);
		termspage.selectTermsCheckBox();
		termspage.selectPrivacyPolicyCheckBox();
		termspage.clickAgreeButton();
		
		CreateAccountPage createAccountPage = new CreateAccountPage(driver, wait);
		createAccountPage.enterEmail(email);
		createAccountPage.enterPassword(correctPassword);
		createAccountPage.confirmPassword(incorrectPassword);
		createAccountPage.clickFirstNameField();
		createAccountPage.checkPasswordErrorMsg(expectedPwdErrorMsg);

	}
  
	@AfterTest
	public void afterTest() {
		
		// Quit Firefox
		driver.quit();
	}

}
