package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertTrue;

public class ThankYouPage {
    public ThankYouPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='m-10 my-16']//span")
    @CacheLookup
    private WebElement thankYouMessage;

    public void verify_thankYouMessage() {
        String message = thankYouMessage.getText();
        assertTrue(message.contains("Thanks for trying us!"));
    }
}
