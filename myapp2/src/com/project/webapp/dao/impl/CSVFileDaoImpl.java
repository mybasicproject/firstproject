package com.project.webapp.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.project.webapp.dao.CSVFileDao;
import com.project.webapp.utility.DbConnection;

public class CSVFileDaoImpl implements CSVFileDao {

	@Override
	public String saveFileData(String csvFilePath) {
		String trunc = "truncate table tmp_person";
		try(Connection con = DbConnection.makeConnection();
			PreparedStatement ps = con.prepareStatement(trunc)) {					
	            ps.execute();		            
		} catch (Exception e) {
			e.printStackTrace();
		}

		String query = "LOAD DATA LOCAL INFILE '" + csvFilePath + "' "
				+ "INTO TABLE tmp_person FIELDS TERMINATED BY ','ENCLOSED BY'\"'"
				+ " LINES TERMINATED BY '\r\n' ignore 1 lines ";
		
		
		try(Connection con = DbConnection.makeConnection();
			PreparedStatement ps = con.prepareStatement(query)) {
			
            int rows = ps.executeUpdate();
            if(rows>0)
        	  System.out.println(rows+" rows Saved");
            else
            	System.out.println("Not saved");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try(Connection con = DbConnection.makeConnection();
			CallableStatement cs = con.prepareCall("call save_record()")) {					
	            cs.execute();		           
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	

}
