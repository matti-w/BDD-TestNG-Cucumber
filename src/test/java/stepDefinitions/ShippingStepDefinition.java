package stepDefinitions;

import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.bdd.base.TestBase;
import com.bdd.pages.ShippingPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShippingStepDefinition extends TestBase {

	ShippingPage shipPage;
	SoftAssert softAssert;


	@Given("^a user navigates to create shipping page$")
	public void a_user_navigates_to_create_shipping_page() throws Throwable {
		driver = initBrowser();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.cssSelector("[id='ups-menuLinks1']")).click();
		driver.findElement(By.xpath("//h3[contains(text(),'New Shipments')]/following-sibling::ul/li[1]/a")).click();
		
		shipPage = new ShippingPage(driver);
		String title = shipPage.getPageTitle();
		Assert.assertEquals(title, "Shipping | UPS - United States");
	}

	@When("^user enters shipping address info$")
	public void user_enters_shipping_address_info(DataTable custAddress) throws Throwable {
		for (Map<String, String> data : custAddress.asMaps(String.class, String.class)) {

			shipPage.enterShippingAddress(data.get("FullName"), data.get("Address"), data.get("ZipCode"),
					data.get("Email"), data.get("Phone"));
		}
	}

	@Then("^system autofiles city and state based on zipcode entered$")
	public void system_autofiles_city_and_state_based_on_zipcode_entered() throws Throwable {
		Thread.sleep(3000);
		softAssert = new SoftAssert();
		
		String city = shipPage.getCityField().getAttribute("value");
		softAssert.assertEquals("FORT WAYNE", city);
		
		Select select = new Select(shipPage.getStateField());
		String stateSelected = select.getFirstSelectedOption().getText();
		softAssert.assertEquals(stateSelected, "Indiana");
		
		softAssert.assertAll();
	}

	@Then("^user clicks on continue button$")
	public void user_clicks_on_continue_button() throws Throwable {
		shipPage.getContinueButton().click();
	}

	@Then("^system displays address entered with edit option$")
	public void system_displays_address_entered_with_edit_option() throws Throwable {
			boolean editButton = driver.findElement(By.cssSelector("[class='ups-section-header'] button")).isDisplayed();
			Assert.assertTrue(editButton);
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
		driver.quit();
	}

}
