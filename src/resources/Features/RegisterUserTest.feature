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
      | username     | password             |
      | zaDE5@abv.bg | JzMHUwaE02EHhh88E4BM |
    