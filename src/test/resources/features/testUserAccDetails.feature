Feature: Test User Account Details

  Background:
    Given The user access practice.automationtesting homepage
    When The user log in into account

  Scenario: The user would like to navigate to the "Account Details" and verify the correct email was used
    When The user click on Account details
    Then User should see the correct email was used

  Scenario: The user would like to enter first and last names to the Account details, make sure they are correct in the input boxes, and save.
    When The user click on Account details
    And The user enter first name
    And  The user enter last name
    And  The user saves changes
    Then The user should be presented with a successful change-making message

  Scenario: The user would like to navigate to his "Addresses" and verify they are not set.
    When The user click on Addresses link
    Then The user should see his Billing and Shipping addresses