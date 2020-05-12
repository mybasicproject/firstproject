package com.project.webapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.project.webapp.model.StdInfo;

public class Test3 {
	public static void delete(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
			PreparedStatement pt = conn.prepareStatement("delete from students where id=?");
			pt.setInt(1, id);
			
			int rows = pt.executeUpdate();
			
			if(rows>0)
				System.out.println("Data is deleted.....");
			else
				System.out.println("Something went wrong...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	 
 }
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int id = s.nextInt();
		delete(id);
	}
}
