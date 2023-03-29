package com.masai.dao;

import com.masai.dto.Account;
import com.masai.dto.Customer;
import com.masai.exception.CustomerException;

public interface CustomerDao {
	
	public String signUpAsACustomer(Customer customer)throws CustomerException;
	
	public String loginAsACustomer(String username, String password)throws CustomerException;
	
	public String updateCustomerDetails(String name, String mobile, String address,int id) throws CustomerException;
	
	public String updatePassword(String new_password, String old_password,int id) throws CustomerException;
	
	public String openSavingsAccount(Account account) throws CustomerException;
	
	public String openLoanAccount(Account account) throws CustomerException;
	
	public void withdrawFromSavingAccount(int money) throws CustomerException;
	
	
}
