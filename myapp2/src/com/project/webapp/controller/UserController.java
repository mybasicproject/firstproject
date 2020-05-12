package com.project.webapp.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.webapp.dao.UserDao;
import com.project.webapp.dao.impl.UserDaoImpl;
import com.project.webapp.model.Address;
import com.project.webapp.model.Name;
import com.project.webapp.model.UserInfo;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	   private static String filePath;
	   private int maxFileSize = 50 * 1024;
	   private int maxMemSize = 4 * 1024;
	   private File file ;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		System.out.println("Method = "+method);
		String message = null;
		if(method.equals("saveRecord")){
			
			String fname = request.getParameter("firstname");
			String lname = request.getParameter("lastname");
			String country = request.getParameter("country");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			String pincode = request.getParameter("pincode");
			String area = request.getParameter("areaname");
			String contact = request.getParameter("contact");
			String email = request.getParameter("email");
			String password = request.getParameter("pass");
			String confirmPassword = request.getParameter("cnfpass");
			Name name = new Name(fname,lname);
			//Address address = new Address(country, state, city, pincode);
			Address address = new Address(country, state, city, pincode);
			UserInfo user = new UserInfo(name, address, contact, area, email, password, confirmPassword);
			
			UserDao userDao = new UserDaoImpl();
			boolean b = userDao.save(user);
			if(b==true){
				message = "Data saved.";
				request.setAttribute("msg", message);
				request.getRequestDispatcher("signup.jsp").forward(request, response);
				//response.sendRedirect("signup.jsp");
			}
			else
				message = "Failed to save data.";
			    request.setAttribute("error", message);
			    request.getRequestDispatcher("signup.jsp").forward(request, response);
				//response.sendRedirect("error.jsp");
			
		}
		if(method.equals("updateRecord")){
			int id = Integer.parseInt(request.getParameter("id"));
			String fname = request.getParameter("firstname");
			String lname = request.getParameter("lastname");
			String country = request.getParameter("country");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			String pincode = request.getParameter("pincode");
			String area = request.getParameter("areaname");
			String contact = request.getParameter("contact");
			String email = request.getParameter("email");
			String password = request.getParameter("pass");
			String confirmPassword = request.getParameter("cnfpass");
			
			Name name = new Name(fname,lname);
			Address address = new Address(country, state, city, pincode);
			UserInfo user = new UserInfo(id,name, address, contact, area, email, password, confirmPassword);
			UserDao userDao = new UserDaoImpl();
			userDao.update(user);
			
		}
		if(method.equals("deleteRecord")){			
			int id = Integer.parseInt(request.getParameter("id"));
			UserDao dao = new UserDaoImpl();
			dao.delete(id);			
		}
		
		if(method.equals("getData")){			
			int id = Integer.parseInt(request.getParameter("id"));
			UserDao dao = new UserDaoImpl();
			UserInfo user = dao.getUserData(id);
			request.setAttribute("userdata", user);
			request.getRequestDispatcher("update.jsp").forward(request, response);			
		}
		
		
		if(method.equals("showAllRecord")){
			
		}
		
		if(method.equals("loginSuccess")){
					
					String username = request.getParameter("username");
					String password = request.getParameter("pwd");	
					UserDao userDao = new UserDaoImpl();
					boolean b = userDao.authenticateUser(username,password);
					if(b==true){
						message = "login successful.";
						request.setAttribute("message", message);
						request.getRequestDispatcher("index.jsp").forward(request, response);
						}
					else
						message = "authentication failed.";
					    request.setAttribute("error", message);
					    request.getRequestDispatcher("index.jsp").forward(request, response);
										
				}

		if(method.equals("loadCountry")){
			System.out.println("From loadCountry method");
			UserDao dao = new UserDaoImpl();
			String json = dao.getAllCountry();
			response.setContentType("application/json");	
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= response.getWriter();
			out.println(json);
			out.close();
		}
		if(method.equals("loadState")){
			System.out.println("From loadState method");
			String countryName = request.getParameter("country_name");
			UserDao dao = new UserDaoImpl();
			String json = dao.getState(countryName);
			response.setContentType("application/json");	
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= response.getWriter();
			out.println(json);
			out.close();
		}
		if(method.equals("loadCity")){
			System.out.println("From loadCity method");
			String stateName = request.getParameter("state_name");
			UserDao dao = new UserDaoImpl();
			String json = dao.getCity(stateName);
			response.setContentType("application/json");	
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= response.getWriter();
			out.println(json);
			out.close();
		}
		if(method.equals("showAll")){
			UserDao dao = new UserDaoImpl();
			String json = dao.showAll();
			response.setContentType("application/json");	
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= response.getWriter();
			out.println(json);
			out.close();
		}
		if(method.equals("uploadData")){
			
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
