@addEmployee
Feature: Add Employee

  Background: 
    When Login with valid credentials
    Then navigate to Add Employee Page
	@emp
  Scenario: Add employee without login details and without middle name
    And enter first and last name
    Then click on saveButton on Add Employee Page
    And verify the employee is added successfully

  Scenario: Add employee with login credentials
    And enter first and last name
    When check login details checkbox
    Then enter login details
    Then click on saveButton on Add Employee Page
    And verify the employee is added successfully

  @parameter
  Scenario: Add employee without login details but with middle name
    When enter first as "Ahmet", middle "Can" and last names "Bicer"
    Then click on saveButton on Add Employee Page
    And verify that "Ahmet Can Bicer" is added successfully

  @examples
  Scenario Outline: Adding multiple employees without login details
    When enter employee "<First Name>","<Middle Name>" and "<Last Name>"
    Then click on saveButton on Add Employee Page
    And verify that "<First Name>","<Middle Name>" and "<Last Name>" is successfully added

    Examples: 
      | First Name | Middle Name | Last Name |
      | Elijah     | Green       | Cabages   |
      | Mathew     | Jones       | Rogers    |
      | Kevin      | Nkushi      | White     |
      | Ahmet      | Yusuf       | Hasan     |

  @dtWithHeader
  Scenario: Adding multiple employees at one execution
    When add multiple employess and verify they are added
      | First Name | Middle Name | Last Name |
      | Elijah     | Green       | Cabages   |
      | Mathew     | Jones       | Rogers    |
      | Kevin      | Nkushi      | White     |
      | Ahmet      | Yusuf       | Hasan     |
@excelTask
  Scenario: Adding multiple employees from excel file
  When add multiple employees from "EmployeeSheet" verify they are added successfully
