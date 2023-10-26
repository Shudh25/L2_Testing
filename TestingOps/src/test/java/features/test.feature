Feature: Test Twitter smoke scenario

  Scenario: Test login
    Given Open the firefox

    When I enter valid username and valid password

    Then user should be able to login successfully