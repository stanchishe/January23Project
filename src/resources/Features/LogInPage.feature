Feature: Log in a existing User
  As a real user
  I would like to be able to log in.

  Scenario Outline:
    Given the browser window is open
    And the correct page is loaded
    When the user enters a valid email <username> and pass <password>
    And clicks the login button
    Then a userId <username> is logged in to the site

    Examples:
      | username     | password             |
      | stanreje@abv.bg | !AutomationTest |