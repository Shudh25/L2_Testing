Feature: Login Functionality

  Scenario: Verify login with valid credentials on jobs portal
    Given User is on the login page
    When User enters valid username and password
    And User clicks the Sign in button
    Then User should be successfully logged in