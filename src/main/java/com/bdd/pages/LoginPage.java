package com.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy (xpath = "//a[contains(text(),'Log In')]")
	WebElement singInLink;
	
	@FindBy (css = "[id='email']")
	WebElement usernameField;
	
	@FindBy (css = "[id='pwd']")
	WebElement passwordField;
	
	@FindBy (css = "[id='submitBtn']")
	WebElement signInButton;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
			PageFactory.initElements(driver, this);
	}
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void clickOnLogIn() {
		singInLink.click();
		
	}
	
	public void enterUsername(String userName) {
		usernameField.sendKeys(userName);
	}
	
	public void enterPassword(String pssWord) {
		passwordField.sendKeys(pssWord);
	}
	
	public void clickOnSigninButton() {
		signInButton.click();
	}
	
	public HomePage loginToApp(String username, String password) {
		clickOnLogIn();
		enterUsername(username);
		enterPassword(password);
		clickOnSigninButton();
		
		return new HomePage(driver);
	}
	
	

}
