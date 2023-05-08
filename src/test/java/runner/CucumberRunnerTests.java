package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = {"src/test/resources/features/SignUp.feature"},
                glue = {"stepDefinitions"},
                monochrome = true,
                plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html", "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml",
                },
                publish = true)
public class CucumberRunnerTests {

}


