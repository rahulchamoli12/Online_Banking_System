package com.masai.dto;

import java.time.LocalDate;

public class Transaction {
	
	private int transaction_id;
	private int amount;
	private String transaction_type;
	private LocalDate transaction_date;
	private int  account_id;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transaction_id, int amount, String transaction_type, LocalDate transaction_date,
			int account_id) {
		super();
		this.transaction_id = transaction_id;
		this.amount = amount;
		this.transaction_type = transaction_type;
		this.transaction_date = transaction_date;
		this.account_id = account_id;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public LocalDate getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}


	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", amount=" + amount + ", transaction_type="
				+ transaction_type + ", transaction_date=" + transaction_date + ", account_id=" + account_id + "]";
	}
	
	
	
}
