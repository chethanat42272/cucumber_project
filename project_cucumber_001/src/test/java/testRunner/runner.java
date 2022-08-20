package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/Feature/"},
		glue="Stepdefinitions",
		dryRun=false,
		monochrome=true,
		plugin = {"json:target/cucumber.json"},	
		tags= "@sanity"
		)
public class runner {

}
