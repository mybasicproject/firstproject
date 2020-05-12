package com.project.webapp.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

import com.project.webapp.dao.ProductDao;
import com.project.webapp.model.ProductInfo;
import com.project.webapp.utility.DbConnection;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean insert(ProductInfo product) {
		String sql = "call p_test_navigation(?,?,?,?,?,?,?)";
		try(Connection con = DbConnection.makeConnection();
			CallableStatement  cs = con.prepareCall(sql)){
			cs.setString(1	, "I");
			cs.setInt(2, 0);
			cs.setString(3, product.getPname());
			cs.setDouble(4, product.getCost());
			cs.setDate(5, product.getMfgDate());
			cs.setDate(6, product.getExpDate());
			cs.registerOutParameter(7, java.sql.Types.VARCHAR);
			
			cs.execute();
			String message = cs.getString(7);
			System.out.println(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void update(ProductInfo product) {
		String sql = "call p_test_navigation(?,?,?,?,?,?,?)";
		try(Connection con = DbConnection.makeConnection();
			CallableStatement  cs = con.prepareCall(sql)){
			cs.setString(1	, "U");
			cs.setInt(2, product.getPid());
			cs.setString(3, product.getPname());
			cs.setDouble(4, product.getCost());
			cs.setDate(5, product.getMfgDate());
			cs.setDate(6, product.getExpDate());
			cs.registerOutParameter(7, java.sql.Types.VARCHAR);
			
			cs.execute();
			String message = cs.getString(7);
			System.out.println(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

	@Override
	public void delete(ProductInfo product) {
		String sql = "call p_test_navigation(?,?,?,?,?,?,?)";
		try(Connection con = DbConnection.makeConnection();
			CallableStatement  cs = con.prepareCall(sql)){
			cs.setString(1	, "D");
			cs.setInt(2, product.getPid());
			cs.setString(3, null);
			cs.setDouble(4, 0);
			cs.setDate(5, null);
			cs.setDate(6, null);
			cs.registerOutParameter(7, java.sql.Types.VARCHAR);
			
			cs.execute();
			String message = cs.getString(7);
			System.out.println(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
