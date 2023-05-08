package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.SignUpPage;
import pageObjects.ThankYouPage;
import utilities.Helper;


import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class SignUpPageDefinitions extends BaseClass  {

    @Given("user is on Sign up page {string}")
    public void user_is_on_sign_up_page(String url) {

        Helper.openPage(url);

    }

    @When("user enters email id as {string}")
    public void user_enters_email_id_as(String email) {
        signUpPage.enter_EmailId(email);

    }

    @Then("user should be able to click Next button successfully")
    public void user_should_be_able_to_click_next_button_successfully() {
        signUpPage.click_NextButton();
    }

    @Then("{string} error message should be displayed")
    public void error_message_should_be_displayed(String errorMsg) {
        assertEquals("Incorrect error message is displayed",errorMsg,signUpPage.get_EmailFieldErorMessage());
    }

    @Then("{string} error message should be displayed post verification")
    public void errorMessageShouldBeDisplayedPostVerification(String ExpectedErrorMsg) {
        String actualErrorMsg = signUpPage.get_VerificationErrorMessage();
        assertEquals("Incorrect error message is displayed",ExpectedErrorMsg,actualErrorMsg);
    }

    @Then("error message should disappear")
    public void error_message_should_disappear() {
        assertFalse(signUpPage.get_if_field_error_message_isDisplayed());
    }

    @Then("verification error message should disappear")
    public void verification_error_message_should_disappear() {
        assertFalse(signUpPage.get_if_verification_error_message_isDisplayed());
    }
}

