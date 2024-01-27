Feature: Logs out user

  Scenario Outline:
    Given the Browser Window is Open
    And the Correct Page is Loaded
    When the User enters a valid Email <username> and Pass <password>
    And Clicks the Login Button
    Then clicks the logout button
    Then the user has logged out

    Examples:
      | username     | password             |
      | stanreje@abv.bg | !AutomationTest |