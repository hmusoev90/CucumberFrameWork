package com.hrms.steps.practice;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodeExamples {

	/*
	 * REST Assured - Java library specifically developed to automate REST endpoints
	 * 
	 * Given - Preparing your request 
	 * When - What action will you perform, what type of call are you making? 
	 * Then - Verification
	 * 
	 */
	/* BaseURI for all endpoints */
	String baseUri = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	/* JWT */
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MDM2MzQzNjEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYwMzY3NzU2MSwidXNlcklkIjoiMTI1OSJ9.LL0RpmwmROdwJiVRiEwSnW1aERHD9_b_0qyrjImlATI";

	static String employeeID;

	// @Test
	public void sampleTest() {

		/* Preparing request for /getOneEmployee.php */
		/* Using .log().all() to print out everything being sent with the request */
		RequestSpecification preparingGetOneEmployeeRequest = given().header("Authorization", token)
				.header("Content-type", "application/json").queryParam("employee_id", "3707").log().all();

		/* Making call to /getOneEmployee.php */
		Response getOneEmployeeResponse = preparingGetOneEmployeeRequest.when().get("/getOneEmployee.php");

		/* One way to print response object */
		// System.out.println(getOneEmployeeResponse.asString());

		/* Second way using rest assured prettyPrint() */
		getOneEmployeeResponse.prettyPrint();

		getOneEmployeeResponse.then().assertThat().statusCode(200);
	}

	@Test
	public void aPOSTcreateEmployee() {
		/* Preparing request for /createEmployee.php request */
		RequestSpecification createEmployeeRequest = given().header("Authorization", token)
				.header("Content-type", "application/json")
				.body("{\r\n" + "  \"emp_firstname\": \"Syntax\",\r\n" + "  \"emp_lastname\": \"Seven\",\r\n"
						+ "  \"emp_middle_name\": \"Batch\",\r\n" + "  \"emp_gender\": \"F\",\r\n"
						+ "  \"emp_birthday\": \"1995-10-11\",\r\n" + "  \"emp_status\": \"Employee\",\r\n"
						+ "  \"emp_job_title\": \"Cloud Architect\"\r\n" + "}");

		/* Making call to /createEmployee.php */
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");

		/* Printing response */
		// createEmployeeResponse.prettyPrint();

		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");

		/* Optional: Printing empID */
		// System.out.println(employeeID);

		/* Verifying status code is 201 */
		createEmployeeResponse.then().assertThat().statusCode(201);

		/* Verifying response body "Messag" is paired with "Entry Created" */
		/*
		 * equalTo() method comes from static Hamscrest package - need to import
		 * manually
		 */
		/* import static org.hamcrest.Matchers.*; */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Syntax"));

		createEmployeeResponse.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
	}

	// @Test
	public void bGETcreatedEmployee() {

		/* Preparing request to get created employee */
		RequestSpecification getEmployeeRequest = given().header("Authorization", token)
				.header("Content-type", "application/json").queryParam("employee_id", employeeID);

		/* Storing response for retrieving created employee */
		Response getEmployeeResponse = getEmployeeRequest.when().get("/getOneEmployee.php");

		/* Printing response */
		getEmployeeResponse.prettyPrint();

		/* Storing response employee ID to compare with static global employeeID */
		String empID = getEmployeeResponse.jsonPath().getString("employee[0].employee_id");

		/* Comparing empID with stored employeeID from created employee call */
		boolean verifyingEmployeeID = empID.equalsIgnoreCase(employeeID);

		/* Asserting to verify the above condition is true */
		Assert.assertTrue(verifyingEmployeeID);

		/* Verifying status code is 200 */
		getEmployeeResponse.then().assertThat().statusCode(200);

		String response = getEmployeeResponse.asString();
		JsonPath js = new JsonPath(response);

		/* Getting all employee info from response body */
		empID = js.getString("employee[0].employee_id");
		String empFirstName = js.getString("employee[0].emp_firstname");
		String empMiddleName = js.getString("employee[0].emp_middle_name");
		String empLastName = js.getString("employee[0].emp_lastname");
		String empBirthday = js.getString("employee[0].emp_birthday");
		String empGender = js.getString("employee[0].emp_gender");
		String empJobTitle = js.getString("employee[0].emp_job_title");
		String empStatus = js.getString("employee[0].emp_status");

		Assert.assertEquals(empID, "27644A");
		Assert.assertEquals(empFirstName, "Syntax");
		Assert.assertEquals(empMiddleName, "Batch");
		Assert.assertEquals(empLastName, "Seven");
		Assert.assertEquals(empBirthday, "1995-10-11");
		Assert.assertEquals(empGender, "Female");
		Assert.assertEquals(empJobTitle, "Cloud Architect");
		Assert.assertEquals(empStatus, "Employee");
	}

	// @Test
	public void cGetAllEmployees() {
		// Preparing request to get all employees
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);

		// Stroring response body into getAllEmployeesResponse
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

		// Printing response body
		// getAllEmployeesResponse.prettyPrint();

		// Storing response as a String
		String response = getAllEmployeesResponse.asString();

		JsonPath js = new JsonPath(response);

		int count = js.getInt("Employees.size()");
		// System.out.println(count);

		/*
		 * for (int i = 0; i < count; i++) {
		 * 
		 * String allEmployeesID = js.getString("Employees[" + i + "].employee_id");
		 * 
		 * if (allEmployeesID.contentEquals(employeeID)) {
		 * System.out.println("Employee ID: " + employeeID + " is present in the body");
		 * String firstNameofEmpID = js.getString("Employee[" + i + "].emp_firstname");
		 * System.out.println(firstNameofEmpID); break; } }
		 */
	}

	@Test
	public void dPutUpdateCreatedEmployee() {

		RequestSpecification putEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token)
				.body("{\r\n" + "  \"employee_id\": \"" + employeeID + "\",\n"
						+ "  \"emp_firstname\": \"SyntaxTeam\",\r\n" + "  \"emp_lastname\": \"SyntaxTeck\",\r\n"
						+ "  \"emp_middle_name\": \"SyntaxMiddle\",\r\n" + "  \"emp_gender\": \"M\",\r\n"
						+ "  \"emp_birthday\": \"2000-10-17\",\r\n" + "  \"emp_status\": \"Super Contractor\",\r\n"
						+ "  \"emp_job_title\": \"Network Administrator\"\r\n" + "}")
				.log().all();

		Response putEmployeesResponse = putEmployeesRequest.when().put("/updateEmployee.php");
		putEmployeesResponse.prettyPrint();

		String response = putEmployeesResponse.asString();

		JsonPath js = new JsonPath(response);
		String empID = js.getString("employee[0].employee_id");
		String empFirstname = js.getString("employee[0].emp_firstname");
		String empMiddlename = js.getString("employee[0].emp_middle_name");
		String empLastname = js.getString("employee[0].emp_lastname");
		String empBirthday = js.getString("employee[0].emp_birthday");
		String empGender = js.getString("employee[0].emp_gender");
		String empJobTitle = js.getString("employee[0].emp_job_title");
		String empStatus = js.getString("employee[0].emp_status");

		Assert.assertEquals(empID, "28807A");
		Assert.assertEquals(empFirstname, "SyntaxTeam");
		Assert.assertEquals(empMiddlename, "SyntaxMiddle");
		Assert.assertEquals(empLastname, "SyntaxTeck");

	}
}
