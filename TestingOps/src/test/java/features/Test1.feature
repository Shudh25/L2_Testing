Feature: Homepage Verification

  Scenario: Verify Homepage Load and time
    Given Open the firefox and open xenonstack website
    When the homepage is loaded
    Then the user should see the homepage