package com.project.webapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.apache.catalina.User;

import com.project.webapp.model.Address;
import com.project.webapp.model.Name;
import com.project.webapp.model.UserInfo;

public class StoreCSV {
	
	public static void save(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			String loadQuery = "LOAD DATA LOCAL INFILE '" + "C:/Users/HP/Desktop/test/myfile.csv" + "' "
					+ "INTO TABLE tmp_person FIELDS TERMINATED BY ','" + 
					" LINES TERMINATED BY '\n' (Id, Name, City) ";
            System.out.println(loadQuery);
            PreparedStatement stmt = con.prepareStatement(loadQuery);
            int rows = stmt.executeUpdate();
            if(rows>0)
        	  System.out.println(rows+" rows Saved");
            else
            	System.out.println("Not saved");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		save();
	}

}
