Feature: Login functionality

  Scenario: Login with valid username and empty password
    Given go to HRMS login page
    When login with valid username and leave password empty
    Then verify error message
    And quit browser
