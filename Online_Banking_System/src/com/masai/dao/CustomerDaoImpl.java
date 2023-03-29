package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.dto.Account;
import com.masai.dto.Customer;
import com.masai.exception.CustomerException;
import com.masai.ui.CustomerUI;
import com.masai.ui.CustomerUseCases;
import com.masai.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public String signUpAsACustomer(Customer customer) throws CustomerException{
		
		String message = "Not Registered...!";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO customer (name,mobile,address,username,password,is_deleted) VALUES(?,?,?,?,?,?)");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getMobile());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getUsername());
			ps.setString(5, customer.getPassword());
			ps.setBoolean(6, false);
			
				if(customer.getMobile().length()<10 && customer.getMobile().length()>10)
					throw new CustomerException("Please Enter Valid Phone Number!");
			
			int row = ps.executeUpdate();
			
			if(row > 0)
				message = "Customer Registration Successfully";
			
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		} 
		
		return message;
	}

	@Override
	public String loginAsACustomer(String username, String password)throws CustomerException {

		String message = "Invalid Credentials!";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM customer where username = ? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				CustomerUseCases.cid = rs.getInt("customer_id");
				message = "Login Successfully ✔";		
			}
			else 
				throw new CustomerException("Please sign up first");
					
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		} 

		return message;
	}

	@Override
	public String updateCustomerDetails(String name, String mobile, String address,int id) throws CustomerException {
		String message = "Not Updated";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("UPDATE customer SET name=?,mobile=?,address=? WHERE customer_id=?");
			ps.setString(1, name);
			ps.setString(2, mobile);
			ps.setString(3, address);
			ps.setInt(4, id);
			
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				message = "Your Details Updated Successfully ✔";		
			}
			
					
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		} 

		return message;
	}

	@Override
	public String updatePassword(String old_password, String new_password,int id) throws CustomerException {
		
		String message = "Password not updated";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("UPDATE customer SET password=? WHERE customer_id=? AND password=?");
			ps.setString(1, new_password);
			ps.setInt(2, id);
			ps.setString(3, old_password);			
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				message = "Your Password Updated Successfully ✔";		
			}
			else
				throw new CustomerException("Insert Correct Old Password");
			
					
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		} 

		return message;
		
	}

	@Override
	public String openSavingsAccount(Account account) throws CustomerException {
		
		String message = "Account not opened yet!";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO account (account_number,account_type,balance,customer_id) VALUES (?,?,?,?)");
			ps.setInt(1, account.getAccount_number());
			ps.setString(2, "saving");
			ps.setInt(3, account.getBalance());
			ps.setInt(4, CustomerUseCases.cid);
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				message = "Your Saving Account Open Successfully ✔";		
			}
			else
				throw new CustomerException("Insert Account details correctly");
			
					
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		} 

		return message;
	}
	
	
	@Override
	public String openLoanAccount(Account account) throws CustomerException {
		
		String message = "Account not opened yet!";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO account (account_number,account_type,balance,customer_id) VALUES (?,?,?,?)");
			ps.setInt(1, account.getAccount_number());
			ps.setString(2, "loan");
			ps.setInt(3, account.getBalance());
			ps.setInt(4, CustomerUseCases.cid);
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				message = "Your Laon Account Open Successfully ✔";		
			}
			else
				throw new CustomerException("Insert Account details correctly");
			
					
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		} 

		return message;
	}

	@Override
	public void withdrawFromSavingAccount(int amount) throws CustomerException {
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("Update account set balance = balance - ? where account_type = ? AND account_id= ?");
			ps.setInt(1, amount);
			
			
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				 System.out.println("Your Laon Account Open Successfully ✔");
			}
			else
				throw new CustomerException("Insert Account details correctly");
			
					
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		} 
		
	}
	
	
	
	
	
	
	

}
