package com.hrms.API.steps;

import com.hrms.utils.APICommonMethods;
import com.hrms.utils.APIConstants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createEmployeesAPI {

	RequestSpecification request;
	Response response;

	@Given("a request is prepared to create employees")
	public void a_request_is_prepared_to_create_employees() {
	}

	@When("employee data provided is {string}, {string}, {string},{string},{string},{string},{string}")
	public void employee_data_provided_is(String employeeFirstName, String employeeLastName, String employeeMiddleName,
			String employeeGender, String employeeBirthday, String employeeJobStatus, String employeeJobTitle) {
		request = APICommonMethods.createEmployeeRequest(GenerateTokenSteps.token,
				APICommonMethods.createEmployeePayload());
	}

	@Then("employees are created")
	public void employees_are_created() {
		response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
		response.prettyPrint();
	}
}
