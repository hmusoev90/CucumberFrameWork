Feature: Name validations against DB

  Scenario: First name validation against DB - searching by Employee ID
    When login with valid credentials
    Then verify the dashboard logo is displayed
    When navigate to employee list
    And search for an employee with valid Employee id "0056266"
    Then click on Search Button
    And verify the table is displayed
    When get first name from the table
    Then get first name from the DB
    Then validate first name from UI against DB
    
