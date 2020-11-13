package com.hrms.stepDefinitions;

import java.sql.Driver;

import org.apache.commons.collections4.bag.TreeBag;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	//Hooks executes before and after step for each Scenario
	@Before
	public void startTest() {
		BaseClass.setUp();
	}

	@After
	public void endTest(Scenario scenario) {
		byte[] screenShot;
		if (scenario.isFailed()) {
			screenShot = CommonMethods.takeScreenshot("failed/" + scenario.getName());
		} else {
			screenShot = CommonMethods.takeScreenshot("passed/" + scenario.getName());
		}
		scenario.attach(screenShot, "image/png", scenario.getName());
		
		BaseClass.tearDown();
	}
}
