package stepDefinitions;

import io.cucumber.java.en.Then;
import utilities.Helper;

import static org.testng.AssertJUnit.assertEquals;

public class LogInPageDefinitions extends BaseClass {

    @Then("user should be navigated to login page")
    public void user_should_be_navigated_to_login_page() {
        logInPage.verify_loginBanner();
        assertEquals("User navigated to incorrect page", "Wally - Login", Helper.getTitle());
    }
}
