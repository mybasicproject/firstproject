package com.project.webapp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.webapp.dao.ProductDao;
import com.project.webapp.dao.impl.ProductDaoImpl;
import com.project.webapp.model.ProductInfo;

import sun.applet.resources.MsgAppletViewer_fr;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String method = request.getParameter("method");
	System.out.println("Method= "+method);
	
	
	if(method.equals("insertData")){
		
		ProductDao dao = new ProductDaoImpl();
		Date d1 = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy");
//			String stringDate = sdf.format(d1);
		java.sql.Date mfgDate = new java.sql.Date(d1.getTime());
		
		Date d2 = new Date();
////			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-mm-yy");
////			String stringDate2 = sdf2.format(d2);
		java.sql.Date expDate = new java.sql.Date(d2.getTime());
		
//		Calendar c = Calendar.getInstance();
//		c.set(Calendar.DATE, 10);
//		c.set(Calendar.MONTH, 05);
//		c.set(Calendar.YEAR, 2020);
//		Date mfgDate = c.getTime();
//		
//		Calendar c2 = Calendar.getInstance();
//		c2.set(Calendar.DATE, 05);
//		c2.set(Calendar.MONTH, 06);
//		c2.set(Calendar.YEAR, 2021);
//		Date expDate = c2.getTime();
		
				
		//dao.insert(new ProductInfo("LED", 32000, mfgDate, expDate));
		//dao.insert(new ProductInfo("Duracell", 45000, mfgDate, expDate));
		dao.insert(new ProductInfo("Eveready", 25000, mfgDate, expDate));
		
	
//		double cost = Double.parseDouble(StringUtils.isBlank(request.getParameter("cost"))==true?
//				"0":StringUtils.isNotBlank(request.getParameter("cost"))==true?"0":request.getParameter("cost"));
	}
	
	if(method.equals("updateData")){
		ProductDao dao = new ProductDaoImpl();
		Date d1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy");
		String stringDate = sdf.format(d1);
		java.sql.Date mfgDate = new java.sql.Date(d1.getTime());
		
		Date d2 = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-mm-yy");
		String stringDate2 = sdf2.format(d2);
		java.sql.Date expDate = new java.sql.Date(d2.getTime());
		
		
		dao.update(new ProductInfo(1, "LED",2000 , mfgDate, expDate));
		
	}
	
	if(method.equals("deleteData")){
		ProductDao dao = new ProductDaoImpl();
		dao.delete(new ProductInfo(1));
		
	}
		
	}
    
	private Date Date(Date time) {
	// TODO Auto-generated method stub
	return null;
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}
	
}
