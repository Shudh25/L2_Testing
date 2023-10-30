Feature: Testing the Logo Redirection for getting back to home

  Scenario: Testing the Logo Redirection
    Given User is on the home
    When User clicks on Contact us Button
    Then User clicks on service1
    Then User clicks on service2