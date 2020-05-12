package com.project.webapp.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CsrfTokenGenerator implements ServletContextListener {


	public void contextDestroyed(ServletContextEvent arg0)  { 
         System.out.println("Context listener Destroyed....");
    }

	public void contextInitialized(ServletContextEvent context)  { 
         /*ServletContext cont = context.getServletContext();
         String csrfValue = RandomStringUtils.random(10, 0, 0, true, true, null, new SecureRandom());
         cont.setAttribute("csrfToken", csrfValue);*/
		System.out.println("Context listener loaded");
    }
	
}
