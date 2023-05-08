package stepDefinitions;

import io.cucumber.java.en.Then;
import utilities.Helper;

import static org.testng.AssertJUnit.assertEquals;

public class ThankYouPageDefinitions extends BaseClass{
    @Then("user should be navigated to thank you page")
    public void user_should_be_navigated_to_ThankYou_page() {

        thankYouPage.verify_thankYouMessage();
        assertEquals("User navigated to incorrect page","Wally - Thankyou", Helper.getTitle());
    }
}
