Feature: Login
  Scenario: user is able to login with valid username and password
    Given user navigates to myAccountMenu
    Given user enters valid username in the username field
    And user enters valid password in the password field
    When user clicks the login button
    Then user is logged in successfully

