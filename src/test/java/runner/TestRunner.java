package runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin = { "pretty","html:target/cucumber.html" ,
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
features = { "src/test/resources/features" }, 
glue = { "stepDefinition", "hooks" }) 



public class TestRunner extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = true)
	public Object[][] scenarios() {

		return super.scenarios();
	}
}


/* The TestRunner class extends AbstractTestNGCucumberTests class, which
 * provides TestNG integration for running Cucumber scenarios.
 * The @DataProvider annotation is used to provide test scenarios data.
 * The scenarios() method overrides the default behavior of providing scenarios 
 * by returning super.scenarios() to include all the defined scenarios*/
