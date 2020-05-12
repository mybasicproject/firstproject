package com.project.webapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;
import com.project.webapp.model.StdInfo;

public class Test1 {
	
	public static void insert(StdInfo stud) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
			PreparedStatement pt = conn.prepareStatement("insert into students(sid,sname,address,email,password,contact) values(?,?,?,?,?,?)");
			pt.setInt(1, stud.getId());
			pt.setString(2, stud.getSname());
			pt.setString(3, stud.getAddress());
			pt.setString(4, stud.getEmail());
			pt.setString(5, stud.getPassword());
			pt.setString(6, stud.getContact());
			
			int rows = pt.executeUpdate();
			
			if(rows>0)
				System.out.println("Data is inserted.....");
			else
				System.out.println("Something went wrong...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	 
 }
	public static void main(String[] args)	{
		StdInfo s = new StdInfo(1,"RAMESH","MUMBAI","RAM@GMAIL.COM","12345","8899223344");
		insert(s);
	}
}
