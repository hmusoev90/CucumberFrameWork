package com.hrms.steps.practice;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class Class01Recap {

	String basUri = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MDM2MzQzNjEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYwMzY3NzU2MSwidXNlcklkIjoiMTI1OSJ9.LL0RpmwmROdwJiVRiEwSnW1aERHD9_b_0qyrjImlATI";
	static String employeeID;

	@Test
	public void recap() {

		// Preparing request to get all employees
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);

		//
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

		// Printing response body
		getAllEmployeesResponse.prettyPrint();

		getAllEmployeesResponse.then().assertThat().statusCode(200);
	}

	@Test
	public void getToken() {

		// Preparing requst body to get token
		RequestSpecification getRequestToken = given().header("Content-Type", "application/json").body(
				"{\r\n" + "  \"email\": \"Zane@gmail.com\",\r\n" + "  \"password\": \"neverDateToGiveUp\"\r\n" + "}");
		;

		// Making a call to generateToken.php
		Response getResponseToken = getRequestToken.when().post("/generateToken.php");

		// Printing response body
		getResponseToken.prettyPrint();
	}
}
