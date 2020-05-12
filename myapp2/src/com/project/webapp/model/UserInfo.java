package com.project.webapp.model;

public class UserInfo {
	private int id;
	private Name name;
	private Address address;
	private String contact;
	private String area;
	private String email;
	private String password;
	private String confirmPassword;	
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(Name name, Address address, String contact, String area, String email, String password,
			String confirmPassword) {
		super();
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.area = area;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}	
	
	public UserInfo(int id, Name name, Address address, String contact, String area, String email, String password,
			String confirmPassword) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.area = area;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + ", area="
				+ area + ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
	
	
	

}
