package stepDefinitions;

import pageObjects.LogInPage;
import pageObjects.SignUpPage;
import pageObjects.ThankYouPage;
import utilities.Helper;

public class BaseClass {

    public SignUpPage signUpPage = new SignUpPage(Helper.getDriver());

    public  ThankYouPage thankYouPage = new ThankYouPage(Helper.getDriver());

    public LogInPage logInPage = new LogInPage(Helper.getDriver());

}
