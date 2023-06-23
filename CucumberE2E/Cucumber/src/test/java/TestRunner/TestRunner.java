package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Test_Features", glue = { "stepdefs" }, monochrome = true, plugin = { "pretty",
		"junit:target/JUnitReports/report.xml", "json:target/JSONReports/report.json",
		"html:target/HtmlReports/report.html" }, tags = "@Functional")
public class TestRunner {

}
