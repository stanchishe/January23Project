Feature: Log in a existing User and check shipping address page
  As a real user
  I would like to be able to log in and see my shipping address page fields are blank and ready to be filled.

  Scenario Outline:
    Given the browser window is Open
    And the correct page is Loaded
    When the user enters a valid Email <username> and pass <password>
    And clicks the Login button
    Then go to address Page
    Then click the edit billing address Button
    When the user enters <first_name> and <last_name> and <company> and <street> and <apartment> and <town> and <post>
    And clicks the save Button
    Then the information is Saved

    Examples:
      | username        | password        | first_name | last_name | company  | street    | apartment | town  | post |
      | stanreje@abv.bg | !AutomationTest | Stanimir   | Mihaylov  | Progress | Cherkovna | 7         | Sofia | 1000 |


