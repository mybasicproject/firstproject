package com.project.webapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	private static Connection con = null;
	
	public static Connection makeConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");			
			return con;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
