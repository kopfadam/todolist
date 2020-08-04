package com.helpers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager implements Serializable {
	private static final long serialVersionUID = 1L;
	Connection conn;


	public DBManager(String url, String user, String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}

	}
	
	public Connection getConnection() {
		
		return conn;
		
	}
}
