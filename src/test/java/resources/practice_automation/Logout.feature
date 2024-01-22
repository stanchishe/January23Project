Feature: Logout
  Scenario: user is able to logout
    Given user is logged in his account
    When user clicks the Sign out button
    Then user is  successfully logout