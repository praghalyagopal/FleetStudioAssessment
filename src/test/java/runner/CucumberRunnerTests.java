package runner;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = {"src/test/resources/features/SignUp.feature"},
                glue = {"stepDefinitions"},
                monochrome = true,
                plugin = {"pretty","html:target/cucumber.html"},
                publish = true)
public class CucumberRunnerTests{

    }


