Feature: Log in a existing User and check shipping address
  As a real user
  I would like to be able to log in and see my shipping address.

  Scenario Outline:
    Given the browser window is Open
    And the correct page is Loaded
    When the user enters a valid Email <username> and pass <password>
    And clicks the Login button
    Then a userId <username> is Logged in to the site
    Then Clicks the Address button
    Then Clicks Edit button

    Examples:
      | username     | password             |
      | stanreje@abv.bg | !AutomationTest |


