Feature: Adding new Employee functionality

  Scenario: Adding new Employee without login details
    When login with valid username and password
    Then Navigate to PIM(menu)
    Then click on Add Employee
    Then fill out the list (Firstname, Middle Name, Last name)
    And click on Save button

  Scenario: Adding new Employee with login details
    When login with valid username and password
    Then Navigate to PIM(menu)
    Then click on Add Employee
    Then fill out the list (Firstname, Middle Name, Last name)
    Then click on _Create Login Details_ checkbox
    Then fill out textboxes (User Name, Password, Confirm Password)
    And click on Save button
