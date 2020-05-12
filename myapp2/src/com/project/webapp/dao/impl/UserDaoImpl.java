package com.project.webapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.project.webapp.dao.UserDao;
import com.project.webapp.model.Address;
import com.project.webapp.model.Name;
import com.project.webapp.model.UserInfo;
import com.project.webapp.utility.DbConnection;

public class UserDaoImpl implements UserDao {
	
	

	@Override
	public boolean save(UserInfo user) {
		String sql = "insert into user_details(f_name,l_name,country,state,city,pincode,"
				+ "area,contact_no,email_id,password,cnfm_password) values(?,?,?,?,?,?,?,?,?,?,?) ";
		try(Connection con = DbConnection.makeConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
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
				return true;
				//System.out.println("Data saved...");
			else
				return false;
				//System.out.println("Something went wrong...");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String showAll() {
		List<Object> array = new ArrayList<>();
		Map<String , Object> map = new HashMap<>();
		try(Connection con = DbConnection.makeConnection();
			PreparedStatement ps = con.prepareStatement("select * from user_details");	) {
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				List<Object> ja = new ArrayList<>();
				ja.add(rs.getInt(1));
				ja.add(rs.getString(2));
				ja.add(rs.getString(3));
				ja.add(rs.getString(4));
				ja.add(rs.getString(5));
				ja.add(rs.getString(6));
				ja.add(rs.getString(7));
				ja.add(rs.getString(8));
				ja.add(rs.getString(9));
				ja.add(rs.getString(10));
				ja.add(rs.getString(11));
				ja.add(rs.getString(12));				
				
				array.add(ja);
				
			}
			map.put("aaData", array);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Gson().toJson(map).toString();
	}

	@Override
	public void update(UserInfo user) {
		try (Connection con = DbConnection.makeConnection();
			PreparedStatement ps = con.prepareStatement("update user_details set f_name=?,l_name=?,country=?,state=?,city=?,pincode=?,area=?,contact_no=?,email_id=?,password=?,cnfm_password=? where u_id=? ");){
			
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
			ps.setInt(12, user.getId());
			
			int rows = ps.executeUpdate();
			if(rows>0)
				System.out.println(rows+" row updated");
			else
				System.out.println("Update failed...");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void delete(int id) {
		String sql= "delete from user_details where u_id = ?";
		try(Connection con = DbConnection.makeConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
								
				ps.setInt(1, id);				
				int rows = ps.executeUpdate();
				if(rows>0)
					System.out.println(rows+ " rows deleted");
				else
					System.out.println("Recored not deleted yet..");
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}

	@Override
	public UserInfo getUserData(int id) {
		try(Connection con = DbConnection.makeConnection();
			PreparedStatement ps = con.prepareStatement("select * from user_details where u_id=?")) {
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			UserInfo user = null;
			while(rs.next()){
				int uid = rs.getInt(1);
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
				user = new UserInfo(id,name, address, contact, area, email, password, cnf_password);				
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public String getAllCountry() {
		List<Object> array = new ArrayList<>();
		Map<String , Object> map = new HashMap<>();
		//Gson gson = new Gson();
		try(Connection con = DbConnection.makeConnection();
			PreparedStatement ps = con.prepareStatement("select * from country")) {			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				List<Object> ja = new ArrayList<>();
				//ja.add(rs.getInt(1));
				ja.add(rs.getString(2));
								
				array.add(ja);
			}
			map.put("countryList", array);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Gson().toJson(map);
	}

	@Override
	public String getState(String countryName) {
		
		List<Object> array = new ArrayList<>();
		Map<String , Object> map = new HashMap<>();
		try(Connection con = DbConnection.makeConnection();
			PreparedStatement ps = con.prepareStatement("select s.sname from state s,country c where c.cid=s.cid and cname=?")) {
			ps.setString(1, countryName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				List<Object> ja = new ArrayList<>();
				ja.add(rs.getString(1));
								
				array.add(ja);
			}
			map.put("stateList", array);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Gson().toJson(map);
	}

	@Override
	public String getCity(String stateName) {
		List<Object> array = new ArrayList<>();
		Map<String , Object> map = new HashMap<>();
		try(Connection con = DbConnection.makeConnection();
			PreparedStatement ps = con.prepareStatement("select ct.city_name from city ct,state s where s.sid=ct.sid and s.sname=?")) {
			ps.setString(1, stateName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				List<Object> ja = new ArrayList<>();
				ja.add(rs.getString(1));
								
				array.add(ja);
			}
			map.put("cityList", array);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Gson().toJson(map);
	}

	@Override
	public boolean authenticateUser(String user,String password) {
		try(Connection con = DbConnection.makeConnection();
			PreparedStatement ps = con.prepareStatement("select * from user_details where email_id=? and password=?")) {
				
				ps.setString(1, user);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					return true;				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		return false;
	}

//	@Override
//	public boolean uploadData() {
//		
//		return false;
//	}

}
