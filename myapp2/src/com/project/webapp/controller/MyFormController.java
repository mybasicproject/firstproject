package com.project.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.oreilly.servlet.MultipartRequest;
import com.project.webapp.dao.CSVFileDao;
import com.project.webapp.dao.impl.CSVFileDaoImpl;
import com.project.webapp.utility.DbConnection;
import com.project.webapp.utility.Utility;


@WebServlet("/MyFormController")
public class MyFormController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	   
	   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		    
			response.setContentType("text/html");
			String filePath = "E:/mypath";
			MultipartRequest mr = new MultipartRequest(request, filePath);
			PrintWriter out = response.getWriter();
			
			String excelFileName = "excelFile.xlsx";
			String csvFileName = "convertedfile.csv";
			
			String inputFile = Utility.getFilePath(filePath, excelFileName);
			String outputFile = Utility.getFilePath(filePath, csvFileName);
			File inFile = new File(inputFile);
			File outFile = new File(outputFile);
			String result = Utility.convertInCSV(inFile, outFile);
			
			if(result.equals("success")){			
				CSVFileDao dao = new CSVFileDaoImpl();
				String csvFilePath = Utility.getFilePath(filePath, csvFileName);
				dao.saveFileData(csvFilePath);
			}
			
		      
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	
}
