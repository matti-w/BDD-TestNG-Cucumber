package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bdd.base.TestBase;
import com.bdd.pages.HomePage;
import com.bdd.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends TestBase{

	//CTRL + SHIFT + F to format feature files
	LoginPage loginPage;
	HomePage homePage;
	
	@Given("^user is already on UPS home page \"([^\"]*)\"$")
	public void user_is_already_on_UPS_home_page(String arg1) throws Throwable {
		
		driver = initBrowser();
//	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
//	    driver = new ChromeDriver();
//	    driver.manage().window().maximize();
//	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    //driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
	    driver.get(prop.getProperty("url"));
	}

	@When("^user clicks on SignIn link$")
	public void user_clicks_on_SignIn_link() throws Throwable {
		loginPage = new LoginPage(driver);
		loginPage.clickOnLogIn();
		//driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
	}

	@Then("^UPS SingIn page should display$")
	public void ups_SingIn_page_should_display() throws Throwable {
	   String title = loginPage.getPageTitle();
		Assert.assertEquals(title, "Login | UPS - United States");
	}

	@Then("^user enters valid credentials \"([^\"]*)\", \"([^\"]*)\"$")
	public void  user_enters_valid_credentials (String username, String password) throws Throwable {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		
//	   driver.findElement(By.cssSelector("[id='email']")).sendKeys(username);
//	   driver.findElement(By.cssSelector("[id='pwd']")).sendKeys(password);
	}

	@Then("^user clicks on signin button$")
	public void user_clicks_on_signin_button() throws Throwable {
		loginPage.clickOnSigninButton();
		//driver.findElement(By.cssSelector("[id='submitBtn']")).click();
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getPageTitle(), "Home | UPS - United States");
	}

	@Then("^user clicks on sign out button$")
	public void user_clicks_on_sign_out_button() throws Throwable {
		
		homePage.clickOnSignout();
		//driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
	
	}

	@Then("^UPS Home Page is displayed$")
	public void ups_Home_Page_is_displayed() throws Throwable {
		Thread.sleep(3000);
	   WebElement loginBtn = driver.findElement(By.xpath("//a[contains(text(),'Log In')]"));
	   Assert.assertTrue(loginBtn.isDisplayed());
	   
	   driver.quit();
	}
	
}
