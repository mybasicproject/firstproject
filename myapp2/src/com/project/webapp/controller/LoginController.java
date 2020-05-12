package com.project.webapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.webapp.dao.LoginDao;
import com.project.webapp.dao.UserDao;
import com.project.webapp.dao.impl.LoginDaoImpl;
import com.project.webapp.dao.impl.UserDaoImpl;
import com.project.webapp.utility.Utility;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		doPost(request, response);
   		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println("method="+method);
		String message = null;
		if(method.equals("authenticateUser")){
			String username = request.getParameter("username");
			String password = request.getParameter("pwd");
			String csrfTokenReq = request.getParameter("csrfToken");
			HttpSession session = request.getSession();
			String csrfToken = (String)session.getAttribute("csrfToken");
			System.out.println("session csrfToken = "+csrfToken);
			System.out.println("Request csrfToken = "+csrfTokenReq);
			LoginDao userDao = new LoginDaoImpl();
			boolean b = userDao.authenticateUser(username,password);
			if(b==true){
				String token = Utility.getToken();
				session.setAttribute("csrfToken", token);
				request.setAttribute("csrfTokenReq", token);
				System.out.println("++++++++++++++++++++++++++++");
				System.out.println("session csrfToken = "+session.getAttribute("csrfToken"));
				System.out.println("Request csrfToken = "+request.getAttribute("csrfTokenReq"));
				message = "login successful.";
				request.setAttribute("message", message);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else{
				String token = Utility.getToken();
				session.setAttribute("csrfToken", token);
				request.setAttribute("csrfTokenReq", token);
				System.out.println("===========================");
				System.out.println("session csrfToken = "+session.getAttribute("csrfToken"));
				System.out.println("Request csrfToken = "+request.getAttribute("csrfTokenReq"));
				message = "authentication failed.";
			    request.setAttribute("error", message);
			    request.getRequestDispatcher("index.jsp").forward(request, response);
			}
								
		}
	}

}
