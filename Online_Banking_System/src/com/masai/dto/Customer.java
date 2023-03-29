package com.masai.dto;

public class Customer {
	
	private int customer_id;
	private String name;
	private String mobile;
	private String address;
	private String username;
	private String password;
	private boolean is_deleted;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customer_id, String name, String mobile, String address, String username, String password,
			boolean is_deleted) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.username = username;
		this.password = password;
		this.is_deleted = is_deleted;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", name=" + name + ", mobile=" + mobile + ", address=" + address
				+ ", username=" + username + ", password=" + password + ", is_deleted=" + is_deleted + "]";
	}
	
	
	
	
	
	
}
