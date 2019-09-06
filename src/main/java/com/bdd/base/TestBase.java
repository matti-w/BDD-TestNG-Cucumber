package com.bdd.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.bdd.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\bdd\\config\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.getMessage();
		}

	}

	public WebDriver initBrowser() {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "/drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_TimeOut, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoad_TimeOut, TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));

		return driver;
	}

}
