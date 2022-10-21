package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    
	public static Connection getCon() {
		Connection con = null;
		String user = "root";
		String pass = "";
		try {
			Class.forName("con.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",user,pass);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
