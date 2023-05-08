package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class SignUpPage {

    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "email")
    @CacheLookup
    private WebElement emailField;

    @FindBy(xpath= "//form[@class='my-10']//button")
    @CacheLookup
    private WebElement nextButton;

    @FindBy(css = ".my-10 p")
    @CacheLookup
    private WebElement emailVerificationMessage;

    @FindBy(css = ".my-10 span")
    @CacheLookup
    private WebElement emailFieldErrorMessage;



    public void enter_EmailId(String email){
        emailField.sendKeys(email);
    }

    public void click_NextButton(){
        nextButton.click();

    }

    public String get_VerificationErrorMessage(){
        return emailVerificationMessage.getText();
    }

    public String get_EmailFieldErorMessage(){
        return emailFieldErrorMessage.getText();
    }

    public boolean get_if_field_error_message_isDisplayed()
    {
        return  emailFieldErrorMessage.isDisplayed();
    }

    public boolean get_if_verification_error_message_isDisplayed(){
        return  emailVerificationMessage.isDisplayed();
    }

}
