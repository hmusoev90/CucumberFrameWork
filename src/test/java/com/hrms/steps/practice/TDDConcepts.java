package com.hrms.steps.practice;

import org.junit.Test;

public class TDDConcepts {

	
	@Test
	public void hello() {
		System.out.println("I will say hello if someone knocks on my door");
	}

	//@Test (dependsOnMethods = {"hello()"})
	public void welcome() {
		System.out.println("I will welcome someone ONLY if there was someone that knocked on my door");
	}

	@Test
	public void tea() {
		System.out.println("I will serve tea to whoever i welcomed to my house");
	}
	
}
