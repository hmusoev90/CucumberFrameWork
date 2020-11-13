package com.hrms.stepDefinitions;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearch extends CommonMethods {
	@When("navigate to employee list")
	public void navigate_to_employee_list() {
		click(dash.pimLinkBtn);
		click(dash.addEmpBtn);
	}

	@When("search for an employee with valid Employee id {string}")
	public void search_for_an_employee_with_valid_Employee_id(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("click on Search Button")
	public void click_on_Search_Button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("verify the table is displayed")
	public void verify_the_table_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("get first name from the table")
	public void get_first_name_from_the_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("validate first name from UI against DB")
	public void validate_first_name_from_UI_against_DB() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
