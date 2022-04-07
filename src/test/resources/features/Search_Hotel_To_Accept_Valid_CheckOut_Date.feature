Feature: This feature is to check the validations in search hotel page

  Background: The user must login into the adactin site
    Given the user opens the adactin site
    When the user enters the username
    And the user enters the password
    And the user clicks the submit button
    When the user selects the location as "Sydney" by "value"
    And the user selects the hotels as "Hotel Creek" by "value"
    And the user selects the "Standard" option in Room Type by "value"
    And the user selects option "1" as Rooms by "index"

  Scenario: This scenario is to check if checkout date accepts valid input ADCTN-2
    And the user enters the checkin date as"10/10/2022"
    And the user enters the checkout date as"9/10/2022"
    And the user enters the search button
    Then the user should not able to see the list of hotels

  Scenario: This scenario is to check if checkin date accepts valid input ADCTN-3
    And the user enters the checkin date as"15/01/2022"
    And the user enters the checkout date as"20/01/2022"
    And the user enters the search button
    Then the user should not able to see the list of hotels

  Scenario: This scenario is to check if correct hotel name is displayed in Select Hotel page ADCTN-4
    And the user enters the checkin date as"25/04/2022"
    And the user enters the checkout date as"28/04/2022"
    And the user enters the search button
    Then the user should be able to see the selected hotel

  Scenario: This scenario is to check if the user is able to see checkout date as entered in SearchHotel page ADCTN-5
    And the user enters the checkin date as"20/04/2022"
    And the user enters the checkout date as"24/04/2022"
    And the user enters the search button
    Then the user should be able to see checkout date as entered in SearchHotel page
