package com.masai.dto;

import java.time.LocalDate;

public class Transaction {
	
	private int account_number;
	private int deposit;
	private int withdraw;
	private LocalDate transaction_date;
	private boolean is_delete;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(int account_number, int deposit, int withdraw, LocalDate transaction_date, boolean is_delete) {
		super();
		this.account_number = account_number;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.transaction_date = transaction_date;
		this.is_delete = is_delete;
	}

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public LocalDate getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}

	public boolean isIs_delete() {
		return is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}

	@Override
	public String toString() {
		return "account_number=" + account_number + ", deposit=" + deposit + ", withdraw=" + withdraw
				+ ", transaction_date=" + transaction_date + ", is_delete=" + is_delete ;
	}

	

	
	
}
