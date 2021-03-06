package com.hrms.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeStepDefinitions extends CommonMethods {

	@When("Login with valid credentials")
	public void login_with_valid_credentials() {
		login.userNametextBox.sendKeys(ConfigsReader.getPropValue("username"));
		login.passwordTextBox.sendKeys(ConfigsReader.getPropValue("password"));
		click(login.btnLogin);
	}

	@Then("navigate to Add Employee Page")
	public void navigate_to_Add_Employee_Page() {
		click(dash.pimLinkBtn);
		click(dash.addEmpBtn);
	}

	@Then("enter first and last name")
	public void enter_first_and_last_name() {
		sendText(addEmp.firstNameField, "Jimmy");
		sendText(addEmp.lastName, "Johns");
	}

	@Then("click on saveButton on Add Employee Page")
	public void click_on_saveButton_on_Add_Employee_Page() {
		click(addEmp.saveButton);
	}

	@Then("verify the employee is added successfully")
	public void verify_the_employee_is_added_successfully() {
		String profileName = persDetails.profileName.getText();
		Assert.assertEquals("Jimmy Johns", profileName);
	}

	@When("enter first as {string}, middle {string} and last names {string}")
	public void enter_first_as_middle_and_last_names(String firstName, String middleName, String lastName) {
		sendText(addEmp.firstNameField, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastName, lastName);
	}

	@Then("verify that {string} is added successfully")
	public void verify_that_is_added_successfully(String fullName) {
		Assert.assertEquals(fullName, persDetails.profileName.getText());
	}

	@When("enter employee {string},{string} and {string}")
	public void enter_employee_and(String firstName, String middleName, String lastName) {
		sendText(addEmp.firstNameField, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastName, lastName);
	}

	@Then("verify that {string},{string} and {string} is successfully added")
	public void verify_that_and_is_successfully_added(String firstName, String middleName, String lastName) {
		String fullName = firstName + " " + middleName + " " + lastName;
		String fullProfileName = persDetails.profileName.getText();
		Assert.assertEquals(fullName, fullProfileName);
	}

	@When("add multiple employess and verify they are added")
	public void add_multiple_employess_and_verify_they_are_added(DataTable employees) {
		List<Map<String, String>> employeeNames = employees.asMaps();

		for (Map<String, String> employeeName : employeeNames) {
			String firstName = employeeName.get("First Name");
			String middleName = employeeName.get("Middle Name");
			String lastName = employeeName.get("Last Name");

			sendText(addEmp.firstNameField, firstName);
			sendText(addEmp.middleName, middleName);
			sendText(addEmp.lastName, lastName);

			click(addEmp.saveButton);

			String actualName = persDetails.profileName.getText();
			String expectedName = firstName + " " + middleName + " " + lastName;
			Assert.assertEquals("Verifying employee names:", expectedName, actualName);
			click(dash.addEmpBtn);
		}
	}

	@When("add multiple employees from {string} verify they are added successfully")
	public void add_multiple_employees_from_verify_they_are_added_successfully(String sheetName) {
		List<Map<String, String>> excelData = ExcelUtility.excelToListMap(Constants.TESTDATA_FILEPATH, sheetName);

		for (Map<String, String> excel : excelData) {
			String firstName = excel.get("FirtsName");
			String middleName = excel.get("MiddleName");
			String lastName = excel.get("LastName");
			
			sendText(addEmp.firstNameField, firstName);
			sendText(addEmp.middleName, middleName);
			sendText(addEmp.lastName, lastName);
			click(addEmp.saveButton);
			
			String actualName = persDetails.profileName.getText();
			String expectedName = firstName+" "+middleName+" "+lastName;
			Assert.assertEquals(expectedName, actualName);
			click(dash.addEmpBtn);
		}
	}

}
