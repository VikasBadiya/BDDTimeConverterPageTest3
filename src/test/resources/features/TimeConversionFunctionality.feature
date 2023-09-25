Feature: converter functionality
  As a user of the time Converter page
  I want to click the button
  So that the counter display Error Message Text.

  Scenario: empty hours field
    Given I am on the time converter page with the Empty field
    When I click the 'Convert to Seconds' button
    Then the Converter page should show the Error Message

  Scenario: empty minutes field
    Given I am on the time converter page with Enter the hours
    When I am give a hours on input field two
    And  After given value I click the 'Convert to Seconds' button
    Then the Converter page should show the Error Message two

  Scenario:  valid hours and minutes
    Given I am on the time converter page with valid hours and minutes
    When I am give a hours on input field two and minutes on input field as thirty
    And  After given two value I click the 'Convert to Seconds' button
    Then the Converter page should show the Result Text