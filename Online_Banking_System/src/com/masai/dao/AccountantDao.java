package com.masai.dao;

import java.util.List;

import com.masai.dto.Account;
import com.masai.dto.Customer;
import com.masai.dto.CustomerAccount;
import com.masai.dto.Transaction;
import com.masai.exception.AccountantException;
import com.masai.exception.CustomerException;

public interface AccountantDao {

		public List<Customer> viewAllCustomers() throws AccountantException;
		
		public CustomerAccount viewByCustomerID(int cid) throws AccountantException;
		
		public List<Account> viewAllAccounts() throws AccountantException;
		
		public Account viewAccountByAccountNumber(int acc_num) throws AccountantException;
		
		public String addAccount(Account account) throws AccountantException;
		
		public String changeStatusToInoperative() throws AccountantException;
		
		public List<Account> viewInoperativeAccounts() throws AccountantException;
		
		public List<Account> viewClosedAccounts() throws AccountantException;
		
		public List<Transaction> transactionByDateRange(String startDate , String endDate) throws CustomerException;
		
		public List<Transaction> transactionMoreThan49k() throws AccountantException;
	
}
