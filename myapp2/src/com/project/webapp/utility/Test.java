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

public class Test {
	
	public static void save(UserInfo user){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			if(con != null){
				System.out.println("Connected");
			}
			else{
				System.out.println("Not connected...");
			}
			PreparedStatement ps = con.prepareStatement("insert into user_details(f_name,l_name,country,state,city,pincode,area,contact_no,email_id,password,cnfm_password) values(?,?,?,?,?,?,?,?,?,?,?) ");
			ps.setString(1, user.getName().getFirstName());
			ps.setString(2, user.getName().getLastName());
			ps.setString(3, user.getAddress().getCountry());
			ps.setString(4, user.getAddress().getState());
			ps.setString(5, user.getAddress().getCity());
			ps.setString(6, user.getAddress().getPincode());
			ps.setString(7, user.getArea());
			ps.setString(8, user.getContact());
			ps.setString(9, user.getEmail());
			ps.setString(10, user.getPassword());
			ps.setString(11, user.getConfirmPassword());
			
			int rows = ps.executeUpdate();
			if(rows>0)
				System.out.println("Data saved...");
			else
				System.out.println("Something went wrong...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showAll(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			PreparedStatement ps = con.prepareStatement("select * from user_details");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String country = rs.getString(4);
				String state = rs.getString(5);
				String city = rs.getString(6);
				String pincode = rs.getString(7);
				String area = rs.getString(8);
				String contact = rs.getString(9);
				String email = rs.getString(10);
				String password = rs.getString(11);
				String cnf_password = rs.getString(12);
				Name name = new Name(fname, lname);
				Address address = new Address(country, state, city, pincode);
				UserInfo user = new UserInfo(id,name, address, contact, area, email, password, cnf_password);
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(UserInfo user){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			if(con != null){
				System.out.println("Connected");
			}
			else{
				System.out.println("Not connected...");
			}
			PreparedStatement ps = con.prepareStatement("update user_details set f_name=?,l_name=?,country=?,state=?,city=?,pincode=?,area=?,contact_no=?,email_id=?,password=?,cnfm_password=? where u_id=? ");
			ps.setString(1, user.getName().getFirstName());
			ps.setString(2, user.getName().getLastName());
			ps.setString(3, user.getAddress().getCountry());
			ps.setString(4, user.getAddress().getState());
			ps.setString(5, user.getAddress().getCity());
			ps.setString(6, user.getAddress().getPincode());
			ps.setString(7, user.getArea());
			ps.setString(8, user.getContact());
			ps.setString(9, user.getEmail());
			ps.setString(10, user.getPassword());
			ps.setString(11, user.getConfirmPassword());
			ps.setInt(12, 1);
			
			int rows = ps.executeUpdate();
			if(rows>0)
				System.out.println("Data Updated...");
			else
				System.out.println("Something went wrong in updation...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(int id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			if(con != null){
				System.out.println("Connected");
			}
			else{
				System.out.println("Not connected...");
			}
			PreparedStatement ps = con.prepareStatement("delete from user_details where u_id= ?");
			
			ps.setInt(1, id);
			
			int rows = ps.executeUpdate();
			if(rows>0)
				System.out.println("Data deleted...");
			else
				System.out.println("Something went wrong in deletion...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 1 to save\nEnter 2 to Select\nEnter 3 to update\nEnter 4 to Delete");
		
		int option = s.nextInt();
		switch (option) {
		case 1:
			Name name = new Name("MANDEEP", "SINGH");
			Address address = new Address("India", "MAHARASTRA", "THANE", "421503");
			save(new UserInfo(name, address, "8286150733", "BDLAPUR", "S@G", "123", "123"));
			break;
			
		case 2:
			showAll();
			break;
		case 3:
			Name nam = new Name("MANDEEP", "SINGH");
			Address add = new Address("India", "MAHARASTRA", "THANE", "421503");
			update(new UserInfo(nam, add, "8286150733", "SAKINAKA", "S@G", "123", "123"));
			break;
		case 4:
			System.out.println("Enter id to delete record");
			int id = s.nextInt();
			delete(id);
		default:
			break;
		}

	}

}
