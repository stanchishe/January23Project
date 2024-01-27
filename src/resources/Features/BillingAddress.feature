Feature: As a real user i want to be able to enter my billing information.

  Scenario Outline:
    Given the browser Window is Open
    And the correct Page is Loaded
    When the user enters a valid Email <username> and Pass <password>
    And clicks the Login Button
    Then go to address page
    Then click the edit billing address button
    When the user enters <first_name> and <last_name> and <company> and <street> and <apartment> and <town> and <post> and <email> and <phone>
    And clicks the save button
#    Then the information is saved

    Examples:
      | username        | password        | first_name | last_name | company  | street    | apartment | town  | post | email           | phone      |
      | stanreje@abv.bg | !AutomationTest | Stanimir   | Mihaylov  | Progress | Cherkovna | 7         | Sofia | 1000 | stanreje@abv.bg | 0878231978 |