package com.hrms.stepDefinitions;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Class01Homework01 extends CommonMethods {
	@Given("go to HRMS login page")
	public void go_to_hrms_login_page() {
		setUp();
	}

	@When("login with valid password only")
	public void login_with_valid_password_only() {
		login.passwordTextBox.sendKeys(ConfigsReader.getPropValue("password"));
		login.btnLogin.click();
	}

	@Then("verify empty username error message")
	public void verify_empty_username_error_message() {
		Assert.assertTrue(login.spanMessage.isDisplayed());
	}

	@Then("quit browser")
	public void quit_browser() {
		tearDown();
	}

}
