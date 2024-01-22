Feature: Register a new User
  As a real user
  I would like to be able to register a new account

  Scenario Outline:
    Given the browser window is open
    And the correct page is loaded
    When the user enters a valid email <username> and pass <password>
    And clicks the registration button
    Then a new userId <username> is registered on the server

    Examples:
      | username      | password             |
      | zaDE11@abv.bg | JzMHUwaE02EHhh88E4BM |

  Scenario Outline:
    Given the browser window is open again
    And the correct page is loaded again
    When the user enters a registered email <username> and pass <password>
    And the user attempts to clicks the registration button
    Then a registered user error is displayed

    Examples:
      | username     | password             |
      | zaDE8@abv.bg | JzMHUwaE02EHhh88E4BM |
