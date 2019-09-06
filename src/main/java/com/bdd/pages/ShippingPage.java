package com.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShippingPage {

	private WebDriver driver;

	@FindBy(css = "[id='originname']")
	WebElement nameField;

	@FindBy(css = "[id='originaddress1']")
	WebElement addressField;
	
	@FindBy(css = "[id='originpostal']")
	WebElement zipField;
	
	@FindBy(css = "[id='origincity']")
	WebElement cityField;
	
	@FindBy(css = "[id='originstate']")
	WebElement stateField;

	@FindBy(css = "[id='originemail']")
	WebElement emailField;

	@FindBy(css = "[id='originphone']")
	WebElement phoneField;
	
	@FindBy(css = "[id='nbsBackForwardNavigationContinueButton']")
	WebElement continueButton;
	
	

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getNameField() {
		return nameField;
	}

	public WebElement getAddressField() {
		return addressField;
	}

	public WebElement getZipField() {
		return zipField;
	}

	public WebElement getCityField() {
		return cityField;
	}

	public WebElement getStateField() {
		return stateField;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPhoneField() {
		return phoneField;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void enterShippingAddress(String fullName, String address, String zipCode, String email, String phone) {
		nameField.sendKeys(fullName);
		addressField.sendKeys(address);
		zipField.sendKeys(zipCode);
		emailField.sendKeys(email);
		phoneField.sendKeys(phone);
	}

	

}
