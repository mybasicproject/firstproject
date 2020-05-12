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
import com.project.webapp.dao.LoginDao;
import com.project.webapp.dao.UserDao;
import com.project.webapp.model.Address;
import com.project.webapp.model.Name;
import com.project.webapp.model.UserInfo;
import com.project.webapp.utility.DbConnection;

public class LoginDaoImpl implements LoginDao {
	
	

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

}
