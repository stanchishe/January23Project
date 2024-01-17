Feature: Login

  Scenario: user is able to login with valid username and password
    Given user is at home page
    And user navigates to myAccount
    When user enters valid username in the username field
    And user enters valid password in the password field
    And user clicks the login button
    Then user is logged in successfully


  Scenario: user is not able to login with invalid username and password
    Given user is at home page
    And user navigates to myAccount
    When user enters invalid username in the username field
    And user enters invalid password in the password field
    And user clicks the login button
    Then error message is displayed


