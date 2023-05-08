package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertEquals;

public class LogInPage {
    @FindBy(css = "#root form h2")
    @CacheLookup
    private WebElement loginBanner;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void verify_loginBanner() {
        String message = loginBanner.getText();
        assertEquals("User navigated to incorrect page", "Sign In", message);
    }

}
