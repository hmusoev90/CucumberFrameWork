package com.hrms.stepDefinitions;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.When;

public class Class01Homework02 extends CommonMethods{

	@When("login with valid username and leave password empty")
	public void login_with_valid_username_and_leave_password_empty() {
	  login.userNametextBox.sendKeys(ConfigsReader.getPropValue("username"));
	  login.btnLogin.click();
	}
}
