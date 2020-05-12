package com.project.webapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.project.webapp.model.StdInfo;

public class Test2 {

	public static void update(StdInfo stud) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
			PreparedStatement pt = conn.prepareStatement("update students set sid=?,sname=?,address=?,email=?,password=?,contact=? where sid=?");
			pt.setInt(1, stud.getId());
			pt.setString(2, stud.getSname());
			pt.setString(3, stud.getAddress());
			pt.setString(4, stud.getEmail());
			pt.setString(5, stud.getPassword());
			pt.setString(6, stud.getContact());
			
			int rows = pt.executeUpdate();
			
			if(rows>0)
				System.out.println("Data is updated.....");
			else
				System.out.println("Something went wrong...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	 
 }
	public static void main(String[] args)
	{
		update(new StdInfo(1,"RAMESH","LUCKNOW","RAM@GMAIL.COM","12345","8899223344"));
	}
	
}
