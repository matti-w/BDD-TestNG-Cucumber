package com.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	WebElement singOutLink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void clickOnSignout() {
		singOutLink.click();
	}

}
