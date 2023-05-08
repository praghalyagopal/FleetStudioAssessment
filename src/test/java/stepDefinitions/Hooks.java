package stepDefinitions;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Helper;

import java.io.File;
import java.io.IOException;

public class Hooks {
    @Before
    public static void setUp() {
        Helper.setUpDriver();

    }

    @After
    public static void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                File sourcePath = ((TakesScreenshot) Helper.getDriver()).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
                Files.copy(sourcePath, destinationPath);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Helper.tearDown();
        }
    }
}

