#Author: Hunter

Feature: Suntax HRMS API Workflow
  Description: This feature file test Syntax HRMS API Workflow

  Background: 
    Given a JWT is generated

  @APIWorkflow
  Scenario: Creating an employee
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for creating en employee is 201
    And the employee is created contains key "Message" and value "Entry Created"
    And the employee ID "Employee[0].employee_id" is stored as a global variable to be used for other calls

  @APIWorkflow
  Scenario: Retrieving created employee
    Given a requst is prepared to retrieve the created employee
    When a GET call is made to retrieve the created employee
    Then the status code for retrieving the created employee is 200
    And the retrieving employee ID "employee[0].employee_id" matches the globally stored employee ID
    And the retrieved data at "employee" mathces the data used to create an employee with employee ID "employee[0].employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title | emp_status |
      | Akbar         | Pirmahmad       | Juraev       | 1989-02-08   | Male       | QA Tester     | Worker     |

  @Progression
  Scenario: Retrieving all employees and verifying that created employee details display in the response
    Given a request is prepared to retrieve all employees
    When a GET call is made to retrieve all employees
    Then the status code fore retrieving all employees is 200
    And the retrieved data contains the globally stored employee ID
    And the retrieved data matches the data that was used to create an employee
