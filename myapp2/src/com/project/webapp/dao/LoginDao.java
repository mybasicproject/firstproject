package com.project.webapp.dao;

public interface LoginDao {
	
	boolean authenticateUser(String user,String password);

}
