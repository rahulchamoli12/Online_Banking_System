package com.masai.dao;

import java.util.List;

import com.masai.dto.Account;
import com.masai.dto.Customer;
import com.masai.dto.Transaction;
import com.masai.exception.CustomerException;

public interface CustomerDao {
	
	public String signUpAsACustomer(Customer customer)throws CustomerException;
	
	public String loginAsACustomer(String username, String password)throws CustomerException;
	
	public String updateCustomerDetails(String f_name,String l_name, String mobile, String address,int id) throws CustomerException;
	
	public String updatePassword(String new_password, String old_password,int id) throws CustomerException;
	
	public String openSavingsAccount(Account account) throws CustomerException;
	
	public String openLoanAccount(Account account) throws CustomerException;
	
	public int viewBalance(int acc_num) throws CustomerException;
	
	public int depositMoney(int acc_no , int amt) throws CustomerException;
	
	public int withdrawMoney(int amount , int account_number) throws CustomerException;
	
	public String transferToAnotherAccount(int acc1, int amount , int acc2) throws CustomerException;
	
	public List<Transaction> transactionByDateRange(String startDate , String endDate, int acc_num) throws CustomerException;
	
	public String closeAccount(int acc_num) throws CustomerException;
	
	public String deleteAccount(int acc_num) throws CustomerException;
	
	
}
