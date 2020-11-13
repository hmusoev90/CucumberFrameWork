package com.hrms.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.openqa.selenium.support.PageFactory;

import com.hrms.API.steps.GenerateTokenSteps;
import com.hrms.testbase.PageInitializer;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class APICommonMethods extends PageInitializer {

	public static String createEmployeeBody() {

		String createEmployeeBody = "{\r\n" + "  \"emp_firstname\": \"Akbar\",\r\n"
				+ "  \"emp_lastname\": \"Juraev\",\r\n" + "  \"emp_middle_name\": \"Pirmahmad\",\r\n"
				+ "  \"emp_gender\": \"M\",\r\n" + "  \"emp_birthday\": \"1989-02-08\",\r\n"
				+ "  \"emp_status\": \"Worker\",\r\n" + "  \"emp_job_title\": \"QA Tester\"\r\n" + "}";

		return createEmployeeBody;
	}

	public static String createEmployeePayload() {

		JSONObject obj = new JSONObject();
		obj.put("emp_firstname", "Akbar");
		obj.put("emp_lastname", "Juraev");
		obj.put("emp_middle_name", "Pirmahmad");
		obj.put("emp_gender", "M");
		obj.put("emp_birthday", "1989-02-08");
		obj.put("emp_status", "Worker");
		obj.put("emp_job_title", "QA Tester");

		return obj.toString();

	}

	/*
	 * public static String createEmployeeBodyMap() { Map<String, String> obj = new
	 * LinkedHashMap<>(); obj.put("emp_firstname", "Jim"); obj.put("emp_lastname",
	 * "Kerry"); obj.put("emp_middle_name", "Overloaded"); obj.put("emp_gender",
	 * "M"); obj.put("emp_birthday", "1989-02-08"); obj.put("emp_status", "Worker");
	 * obj.put("emp_job_title", "QA Tester"); return obj.toString(); }
	 */

	/**
	 * Use this method to create an Employee
	 * 
	 * @param token
	 * @param createEmployeeBody
	 * @return
	 */
	public static RequestSpecification createEmployeeRequest(String token, String createEmployeeBody) {
		RequestSpecification request = given().header("Authorization", token).header("Content-Type", "application/json")
				.body(createEmployeeBody);
		return request;

	}

	/**
	 * Use this method to GET an employee
	 * 
	 * @param token
	 * @param employeeID
	 * @return
	 */
	public static RequestSpecification getOneEmployeeRequest(String token, String employeeID) {
		RequestSpecification request = given().header("Content-Type", "application/json").header("Authorization", token)
				.param("employee_id", employeeID);
		return request;
	}

	/**
	 * Use this method to Generate a Token
	 * 
	 * @param generateTokenBody
	 * @return
	 */
	public static RequestSpecification generateTokenRequest(String generateTokenBody) {
		return given().header("Content-Type", "application/json").body(generateTokenBody);
	}

}
