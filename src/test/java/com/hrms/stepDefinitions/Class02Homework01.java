package com.hrms.stepDefinitions;

import org.openqa.selenium.interactions.Actions;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Class02Homework01 extends CommonMethods {

	@When("login with valid username and password")
	public void login_with_valid_username_and_password() {
		login.userNametextBox.sendKeys(ConfigsReader.getPropValue("username"));
		login.passwordTextBox.sendKeys(ConfigsReader.getPropValue("password"));
		login.btnLogin.click();
	}

	@Then("Navigate to PIM\\(menu)")
	public void navigate_to_PIM_menu() {
		waitForClickability(dash.pimLinkBtn);
		dash.pimLinkBtn.click();
	}

	@Then("click on Add Employee")
	public void click_on_Add_Employee() {
		waitForClickability(dash.addEmpBtn);
		dash.addEmpBtn.click();
	}

	@Then("fill out the list \\(Firstname, Middle Name, Last name)")
	public void fill_out_the_list_Firstname_Middle_Name_Last_name() {
		addEmp.firstNameField.sendKeys("Elizabeth");
		addEmp.middleName.sendKeys("Hunter");
		addEmp.lastName.sendKeys("Wick");
	}

	@Then("click on Save button")
	public void click_on_Save_button() {
		waitForClickability(addEmp.saveButton);
		addEmp.saveButton.click();
	}
	
	@Then("click on _Create Login Details_ checkbox")
	public void click_on__Create_Login_Details__checkbox() {
	    addEmp.createLoginDetailsCheckbox.click();
	}

	@Then("fill out textboxes \\(User Name, Password, Confirm Password)")
	public void fill_out_textboxes_User_Name_Password_Confirm_Password() {
	    addEmp.userName.sendKeys("JohnWick0204JohnWick02");
	    addEmp.userPassword.sendKeys("Wick01020304Wick01020304");
	    addEmp.confirmPassword.sendKeys("Wick01020304Wick01020304");
	    
	}

}
