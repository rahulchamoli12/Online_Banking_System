package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Account;
import com.masai.dto.Customer;
import com.masai.dto.CustomerAccount;
import com.masai.exception.AccountantException;
import com.masai.exception.CustomerException;
import com.masai.ui.CustomerUI;
import com.masai.util.DBUtil;

public class AccountantDaoImpl implements AccountantDao{

	@Override
	public List<Customer> viewAllCustomers() throws AccountantException {
		
		List<Customer> customers = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM customer ");
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer cus = new Customer();
				cus.setCustomer_id(rs.getInt(1));
				cus.setName(rs.getString(2));
				cus.setMobile(rs.getString(3));
				cus.setAddress(rs.getString(4));
				cus.setUsername(rs.getString(5));
				cus.setPassword(rs.getString(6));
				cus.setIs_deleted(false);
				
				customers.add(cus);
				
			}
			
			if(customers.size() == 0)
				throw new AccountantException("No customers available");
					
		} catch (SQLException e) {
			throw new AccountantException(e.getMessage());
		} 
	
		return customers;
	}

	@Override
	public CustomerAccount viewByCustomerID(int cid) throws AccountantException {
	
		CustomerAccount caccount;
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("SELECT c.customer_id,c.name,c.mobile,c.address,a.account_number,a.account_type,a.balance,a.status from customer c INNER JOIN account a ON c.customer_id = a.customer_id");
						
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				caccount = new CustomerAccount();
				caccount.setCustomer_id(rs.getInt(1));
				caccount.setName(rs.getString(2));
				caccount.setMobile(rs.getString(3));
				caccount.setAddress(rs.getString(4));
				caccount.setAccount_number(rs.getInt(5));
				caccount.setAccount_type(rs.getString(6));
				caccount.setBalance(rs.getInt(7));
				caccount.setStatus(rs.getString(8));	
			}
			
			else
				throw new AccountantException("No customers available with customer id : " + cid);
					
		} catch (SQLException e) {
			throw new AccountantException(e.getMessage());
		} 
	return caccount;
	}
	
	
	@Override
	public List<Account> viewAllAccounts() throws AccountantException {
		
		List<Account> accounts = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM account ");
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account account = new Account();
				account.setAccount_id(rs.getInt(1));
				account.setAccount_number(rs.getInt(2));
				account.setAccount_type(rs.getString(3));
				account.setBalance(rs.getInt(4));
				account.setCustomer_id(rs.getInt(5));
//				account.setPin(rs.getInt(6));
				account.setStatus(rs.getString(7));
				account.setIs_deleted(false);
				
				accounts.add(account);
				
			}
			
			if(accounts.size() == 0)
				throw new AccountantException("No accounts available");
					
		} catch (SQLException e) {
			throw new AccountantException(e.getMessage());
		} 
	
		return accounts;
	}
	

	@Override
	public Account viewAccountByAccountNumber(int acc_num) throws AccountantException {
		
		Account account;
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM account where account_number = ?");
			ps.setInt(1, acc_num);
						
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				account = new Account();
				account.setAccount_id(rs.getInt(1));
				account.setAccount_number(rs.getInt(2));
				account.setAccount_type(rs.getString(3));
				account.setBalance(rs.getInt(4));
				account.setCustomer_id(rs.getInt(5));
//				account.setPin(rs.getInt(6));
				account.setStatus(rs.getString(7));
				account.setIs_deleted(false);
			}
			
			else
				throw new AccountantException("No account available with account number : " + acc_num);
					
		} catch (SQLException e) {
			throw new AccountantException(e.getMessage());
		} 
	
		return account;
	}

	
	
	
	
	
}
