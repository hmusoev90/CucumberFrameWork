package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class HW01 {

	/*
	 * HW: get the resulttest metadata store it in arrayList, Retrieve from
	 * arrayList and print in console also get column type name and get table names
	 */
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";

	@Test
	public void DBConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB Connection Succesful");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_job_title");
		rs.next();
		String jobTitle = rs.getString("job_title");
		System.out.println(jobTitle);
		Set<String> SetOfJobTitle = new HashSet<>();

		while (rs.next()) {
			String allData = rs.getObject("job_title").toString();
			System.out.println(allData);
		}

		rs.close();
		st.close();
		conn.close();
	}
}
