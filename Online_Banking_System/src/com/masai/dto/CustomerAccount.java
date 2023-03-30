package com.masai.dto;

public class CustomerAccount {
	
	private int customer_id;
	private String first_name;
	private String last_name;
	private String mobile;
	private String address;
	private int account_number;
	private String account_type;
	private int balance;
	private String status;
	
	public CustomerAccount() {
		// TODO Auto-generated constructor stub
	}

	public CustomerAccount(int customer_id, String first_name, String last_name, String mobile, String address,
			int account_number, String account_type, int balance, String status) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.address = address;
		this.account_number = account_number;
		this.account_type = account_type;
		this.balance = balance;
		this.status = status;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", mobile=" + mobile + ", address=" + address + ", account_number=" + account_number
				+ ", account_type=" + account_type + ", balance=" + balance + ", status=" + status ;
	}

	
	
	
	
	
}
