package com.hrms.API.steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hrms.utils.APIConstants;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.APICommonMethods;

public class APIFinalSteps extends CommonMethods {

	RequestSpecification request;
	Response response;
	// String BaseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	static String employeeID;

	@Given("a request is prepared to create an employee")
	public void a_request_is_prepared_to_create_an_employee() {
		// 1st Way
		// request = given().header("Content-Type",
		// "application/json").header("Authorization", GenerateTokenSteps.token)
		// .body(APICommonMethods.createEmployeePayload()).log().all();

		/* 2nd Way */
		/*
		 * request = given().header("Authorization",
		 * GenerateTokenSteps.token).header("Content-Type", "application/json")
		 * .body(CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON));
		 */
		// request = APIMethods.createEmployeeRequest(GenerateTokenSteps.token,
		// APICommonMethods.createEmployeePayload());

		request = APICommonMethods.createEmployeeRequest(GenerateTokenSteps.token,
				CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON));
	}

	@When("a POST call is made to create an employee")
	public void a_POST_call_is_made_to_create_an_employee() {
		response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
	}

	@Then("the status code for creating en employee is {int}")
	public void the_status_code_for_creating_en_employee_is(int code) {
		response.then().assertThat().statusCode(code);
	}

	@Then("the employee is created contains key {string} and value {string}")
	public void the_employee_is_created_contains_key_and_value(String key, String value) {
		response.then().assertThat().body(key, equalTo(value));

	}

	@Then("the employee ID {string} is stored as a global variable to be used for other calls")
	public void the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls(String call) {
		employeeID = response.jsonPath().getString(call);
		System.out.println(employeeID);
	}

	@Given("a requst is prepared to retrieve the created employee")
	public void a_requst_is_prepared_to_retrieve_the_created_employee() {
		request = APICommonMethods.getOneEmployeeRequest(GenerateTokenSteps.token, employeeID).log().all();
	}

	@When("a GET call is made to retrieve the created employee")
	public void a_GET_call_is_made_to_retrieve_the_created_employee() {
		response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
		response.prettyPrint();
	}

	@Then("the status code for retrieving the created employee is {int}")
	public void the_status_code_for_retrieving_the_created_employee_is(int statusCode) {
		response.then().assertThat().statusCode(statusCode);
	}

	@Then("the retrieving employee ID {string} matches the globally stored employee ID")
	public void the_retrieving_employee_ID_matches_the_globally_stored_employee_ID(String ID) {
		response.then().assertThat().body(ID, equalTo(employeeID));

	}

	@Then("the retrieved data at {string} mathces the data used to create an employee with employee ID {string}")
	public void the_retrieved_data_at_mathces_the_data_used_to_create_an_employee_with_employee_ID(String employeeObject,
			String responseEmployeeID, DataTable dataTable) {
		
		List<Map<String,String>> expectedData = dataTable.asMaps();
		
		List<Map<String,String>> actualData = response.body().jsonPath().get(employeeObject);
		
		int index=0;
		
		for (Map<String, String> map : expectedData) {
			Set<String> keys = map.keySet();
			for (String key : keys) {
				String expectedValue = map.get(key);
				String actualValue;
			}
		}
	}

	@Given("a request is prepared to retrieve all employees")
	public void a_request_is_prepared_to_retrieve_all_employees() {

	}

	@When("a GET call is made to retrieve all employees")
	public void a_GET_call_is_made_to_retrieve_all_employees() {

	}

	@Then("the status code fore retrieving all employees is {int}")
	public void the_status_code_fore_retrieving_all_employees_is(Integer int1) {

	}

	@Then("the retrieved data contains the globally stored employee ID")
	public void the_retrieved_data_contains_the_globally_stored_employee_ID() {

	}

	@Then("the retrieved data matches the data that was used to create an employee")
	public void the_retrieved_data_matches_the_data_that_was_used_to_create_an_employee() {

	}

}
