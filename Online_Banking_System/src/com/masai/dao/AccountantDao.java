package com.masai.dao;

import java.util.List;

import com.masai.dto.Account;
import com.masai.dto.Customer;
import com.masai.dto.CustomerAccount;
import com.masai.exception.AccountantException;

public interface AccountantDao {

		public List<Customer> viewAllCustomers() throws AccountantException;
		
		public CustomerAccount viewByCustomerID(int cid) throws AccountantException;
		
		public List<Account> viewAllAccounts() throws AccountantException;
		
		public Account viewAccountByAccountNumber(int acc_num) throws AccountantException;
		
		public String addAccount(Account account) throws AccountantException;
	
}
