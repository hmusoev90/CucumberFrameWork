Feature: Login functionality

  Scenario: Login with invalid credentials
    Given go to HRMS login page
    When login with valid password only
    Then verify empty username error message
    And quit browser
