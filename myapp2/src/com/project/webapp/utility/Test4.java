package com.project.webapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.webapp.model.StdInfo;


public class Test4 {

	public static void showData(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
			PreparedStatement pt = conn.prepareStatement("select * from students");
			ResultSet rt = pt.executeQuery();
			while(rt.next()){
				int id = rt.getInt(1);
				String name = rt.getString(2);
				String address = rt.getString(3);
				String email = rt.getString(4);
				String password = rt.getString(5);
				String contact = rt.getString(6);
				StdInfo us = new StdInfo(id,name, address, email, password,contact);
				System.out.println(us);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		showData();
	}
}
