package com.project.webapp.controller;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;

import com.project.webapp.utility.Utility;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From Homecontroller");
		String csrfValue = Utility.getToken();
		//String csrfValue = RandomStringUtils.randomAlphanumeric(20);
		HttpSession session = request.getSession();
		//ServletContext application = request.getServletContext();
	
		session.setAttribute("csrfToken", csrfValue);
		request.setAttribute("csrfTokenReq", csrfValue);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
