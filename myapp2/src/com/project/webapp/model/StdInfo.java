package com.project.webapp.model;

public class StdInfo {
	private int id;
	private String sname;
	private String address;
	private String email;
	private String password;
	private String contact;
	
	 public StdInfo() {
		// TODO Auto-generated constructor stub
	}
	public StdInfo(int id, String sname, String address, String email, String password, String contact) {
		super();
		this.id = id;
		this.sname = sname;
		this.address = address;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "StdInfo [id=" + id + ", sname=" + sname + ", address=" + address + ", email=" + email + ", password="
				+ password + ", contact=" + contact + "]";
	}
}
