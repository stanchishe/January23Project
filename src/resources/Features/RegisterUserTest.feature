Feature: Register a new User
  As a real user
  I would like to be able to register a new account

  Scenario Outline:
    Given the browser window is openn
    And the correct page is loadedd
    When the user enters a valid email <username> and passs <password>
    And clicks the registration buttonn
    Then a new userId <username> is registered on the serverr

    Examples:
      | username     | password             |
      | kyrami@abv.bg | !AutomationTest |
