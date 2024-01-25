Feature: Test User Account Details

  Background:
    Given The user access practice.automationtesting homepage
    When  The user clicks on my account button
    And   The user log in into account

  @AccountDetails
  Scenario: The user would like to navigate to the "Account Details" and verify the correct email was used
    When The user clicks on Account details
    Then User should see the correct email was used

  @AccountDetails
  Scenario: The user would like to enter first and last names to the Account details, make sure they are correct in the input boxes, and save.
    When The user clicks on Account details
    And  The user enters a first name
    And  The user enters a last name
    And  The user saves changes
    Then The user should be presented with a successful change-making message

  @Addresses
  Scenario: The user would like to navigate to his "Addresses" and verify they are not set.
    When The user clicks on Addresses link
    Then The user should see Billing and Shipping addresses

  @Addresses
  Scenario: The user would like to enter billing address information correctly and save the changes
    When The user clicks on Addresses link
    And  The user clicks on the billing edit button
    And  The user enters a billing firstname
    And  The user enters a billing lastname
    And  The user enters a billing phone number
    And  The user selects a billing country
    And  The user enters a billing street address
    And  The user enters a billing city
    And  The user enters a billing state
    And  The user enters a billing postcode
    And  The user clicks on the billing Save Address button
    Then The user should be able to save the data

  @Addresses
  Scenario: The user would like to enter Shipping address information correctly and save the changes
    When The user clicks on Addresses link
    And  The user clicks on the shipping edit button
    And  The user enters a shipping firstname
    And  The user enters a shipping lastname
    And  The user selects a shipping country
    And  The user enters a shipping street address
    And  The user enters a shipping city
    And  The user enters a shipping postcode
    And  The user clicks on the shipping Save Address button
    Then The user should be able to save the data

