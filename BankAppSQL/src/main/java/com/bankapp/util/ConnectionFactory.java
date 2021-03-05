package com.bankapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	//private static final String URL = "jdbc:postgresql://roc2007.c2ywefhxo11e.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=bankappsql";
	//private static final String USERNAME = "postgres";
	//private static final String PASSWORD = "M01041972i";
	
	private static final String URL = System.getenv("DB_URL");
	private static final String USERNAME = System.getenv("DB_USERNAME");
	private static final String PASSWORD = System.getenv("DB_PASSWORD");

	private static Connection conn;
	
	public static Connection getConnection() {
		
		try {
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
