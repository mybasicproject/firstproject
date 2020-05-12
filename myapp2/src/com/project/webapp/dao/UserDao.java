package com.project.webapp.dao;

import com.project.webapp.model.UserInfo;

public interface UserDao {
	
	boolean save(UserInfo user);
	String showAll();
	void update(UserInfo user);
	void delete(int id);
	UserInfo getUserData(int id);
	String getAllCountry();
	String getState(String countryName);
	String getCity(String stateName);
	boolean authenticateUser(String user,String password);
	//boolean uploadData();
}
