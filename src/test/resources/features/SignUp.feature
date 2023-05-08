Feature: Sign up to Wallyax Application

  Background:
    Given user is on Sign up page "https://wallyax.com/get-started/"

  Scenario: Sign up with valid credentials
    When user enters email id as "fleet@mail.co"
    And user should be able to click Next button successfully
    Then user should be navigated to thank you page

  Scenario: Sign up with existing user details
    When user enters email id as "verixo2897@syinxun.com"
    And user should be able to click Next button successfully
    Then user should be navigated to login page

  Scenario: Signup with credentials for which verification token is already generated but not verified
    When user enters email id as "sakavi3225@saeoil.com"
    And user should be able to click Next button successfully
    Then "Verification token has been already sent to your mail.Please Verify" error message should be displayed post verification

  Scenario: Signup with credentials for which verification token is already generated but not verified
    When user enters email id as "test@gmail.com"
    And user should be able to click Next button successfully
    Then "Provide Organisation Mail Id" error message should be displayed post verification

  Scenario: Verify if error message if displayed if no data is entered in email field
    When user should be able to click Next button successfully
    Then "* E-mail is mandatory" error message should be displayed

  Scenario: Verify if error message if displayed if invalid data is entered in email field
    When user enters email id as "xyz"
    And user should be able to click Next button successfully
    Then "* Invalid Email Id" error message should be displayed

  Scenario: Verify if error message if displayed if invalid data is entered in email field
    When user enters email id as "xyz#gmail.com"
    And user should be able to click Next button successfully
    Then "* Invalid email format" error message should be displayed

      #Test FAILED
  Scenario: Verify if the error message disappears when the user re-types incorrect email ID in the email field
    When user enters email id as "xyz#gmail.com"
    And user should be able to click Next button successfully
    Then "* Invalid email format" error message should be displayed
    And user enters email id as "xyz@gmail.co"
    Then error message should disappear

  Scenario: Verify if the error message disappears when the user re-types incorrect email ID format in the email field
    When user enters email id as "xyz@gmail.com"
    And user should be able to click Next button successfully
    Then "Provide Organisation Mail Id" error message should be displayed post verification
    And user enters email id as "xyz@gmail.co"
    Then verification error message should disappear

    #Test FAILED
  Scenario Outline: Verify if error error message is displayed for invalid input for email field and submitting via Enter key
    When user enters email id as "<emailID>"
    And user hits Enter button
    Then "* Invalid email format" error message should be displayed
    Examples:
      | emailID      |
      | testmail.com |
      | abc          |

  Scenario: Verify if placeholder is displayed for email field
    Then placeholder should be displayed for email field
