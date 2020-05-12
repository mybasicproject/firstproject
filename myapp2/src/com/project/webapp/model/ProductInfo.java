package com.project.webapp.model;

import java.sql.Date;

public class ProductInfo {
	private int pid;
	private String pname;
	private double cost;
	private Date mfgDate;
	private Date expDate;
	
	
	public ProductInfo() {

		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductInfo(int pid) {
		super();
		this.pid = pid;
	}

	public ProductInfo(int pid, String pname, double cost, Date mfgDate, Date expDate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
	}
	public ProductInfo(String pname, double cost, Date mfgDate, Date expDate) {
		super();
		this.pname = pname;
		this.cost = cost;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Date getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "ProductInfo [pid=" + pid + ", pname=" + pname + ", cost=" + cost + ", mfgDate=" + mfgDate + ", expDate="
				+ expDate + "]";
	}
		
	
	
}
