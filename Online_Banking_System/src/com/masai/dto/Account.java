package com.masai.dto;

public class Account {
	
	private int account_number;
	private String account_type;
	private int balance;
	private int customer_id;
	private String status;
	private boolean is_close;
	private boolean is_deleted;
	
	
	public Account() {
		// TODO Auto-generated constructor stub
	}


	public Account(int account_number, String account_type, int balance, int customer_id, String status,
			boolean is_close, boolean is_deleted) {
		super();
		this.account_number = account_number;
		this.account_type = account_type;
		this.balance = balance;
		this.customer_id = customer_id;
		this.status = status;
		this.is_close = is_close;
		this.is_deleted = is_deleted;
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


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public boolean isIs_close() {
		return is_close;
	}


	public void setIs_close(boolean is_close) {
		this.is_close = is_close;
	}


	public boolean isIs_deleted() {
		return is_deleted;
	}


	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}


	@Override
	public String toString() {
		return "account_number=" + account_number + ", account_type=" + account_type + ", balance=" + balance
				+ ", customer_id=" + customer_id + ", status=" + status + ", is_close=" + is_close  ;
	}
	
	
}
