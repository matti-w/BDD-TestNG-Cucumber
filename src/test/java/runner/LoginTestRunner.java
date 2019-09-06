package runner;


import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;



/*
 * Cucumber Options:
 * dry run - checks mapping of all the steps in feature file (once dryRun passes then turn dryRun false)
 * features - folder_name or each file name
 * glue - location of stepdefinitions
 * tags - defined in feature file
 * monochrome - display output in readable format
 * format/plugin - 
 * strict = true means it will fail execution if there are any pending/undefined executions
 */
//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\features\\login.feature",
        glue = {"stepDefinitions"},
        dryRun = false,
        monochrome = true,
        strict = false,
        plugin = {
        		"pretty", 
        		 "html:target/cucumber-reports/cucumber-pretty",
                 "json:target/cucumber-reports/CucumberTestReport.json", 
                 "json:target/cucumber-reports/CucumberTestReport.json"
        		}
        )
public class LoginTestRunner  {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	 
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }

	
}
