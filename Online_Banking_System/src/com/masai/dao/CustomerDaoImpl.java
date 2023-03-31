package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Account;
import com.masai.dto.Customer;
import com.masai.dto.Transaction;
import com.masai.exception.CustomerException;
import com.masai.ui.CustomerUI;
import com.masai.ui.CustomerUseCases;
import com.masai.ui.UIMain;
import com.masai.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao{
	
	public static void account_number() {
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("SELECT * from account where customer_id = ?");
			
			ps.setInt(1, CustomerUseCases.cid);
			
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				UIMain.account_number = res.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String signUpAsACustomer(Customer customer) throws CustomerException{
		
		String message = "Not Registered...!";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO customer (first_name, last_name,mobile,address,username,password,is_deleted) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, customer.getFirst_name());
			ps.setString(2, customer.getLast_name());
			ps.setString(3, customer.getMobile());
			ps.setString(4, customer.getAddress());
			ps.setString(5, customer.getUsername());
			ps.setString(6, customer.getPassword());
			ps.setBoolean(7, false);
			
			
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
				CustomerUI.cu_name = rs.getString("first_name");
					message = "Login Successfully ✔";
				}
			else 
				throw new CustomerException("Invalid Credentials!-----");
					
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		} 

		return message;
	}

	@Override
	public String updateCustomerDetails(String f_name,String l_name, String mobile, String address,int id) throws CustomerException {
		String message = "-----------------------------------------------------------------\r\n"
				+ "|						Not Updated 							|\r\n"
				+"-----------------------------------------------------------------\r\n";	
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("UPDATE customer SET first_name=?,last_name=?,mobile=?,address=? WHERE customer_id=? AND is_deleted =0");
			ps.setString(1, f_name);
			ps.setString(2, l_name);
			ps.setString(3, mobile);
			ps.setString(4, address);
			ps.setInt(5, id);
			
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				message = "-----------------------------------------------------------------\r\n"
						+ "|			 Your Details Updated Successfully ✔ 			 |\r\n"
						+"-----------------------------------------------------------------\r\n";		
			}
			
					
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		} 

		return message;
	}

	@Override
	public String updatePassword(String old_password, String new_password,int id) throws CustomerException {
		
		String message = "-----------------------------------------------------------------\r\n"
				+ "|				 Password not updated					 |\r\n"
				+"-----------------------------------------------------------------\r\n";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("UPDATE customer SET password=? WHERE customer_id=? AND password=? AND is_deleted =0");
			ps.setString(1, new_password);
			ps.setInt(2, id);
			ps.setString(3, old_password);			
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				message = "-----------------------------------------------------------------\r\n"
						+ "|           Your Password Updated Successfully ✔ 			|\r\n"
						+"-----------------------------------------------------------------\r\n";		
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
		
		String message = "-----------------------------------------------------------------\r\n"
				+ "|            	    Account not opened yet!            	  |\r\n"
				+"-----------------------------------------------------------------\r\n";	
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO account (account_number,account_type,balance,customer_id) VALUES (?,?,?,?)");
			ps.setInt(1, account.getAccount_number());
			ps.setString(2, "saving");
			ps.setInt(3, account.getBalance());
			ps.setInt(4, CustomerUseCases.cid);
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				message =  "-----------------------------------------------------------------\r\n"
						+ "|          Your Saving Account Open Successfully ✔             |\r\n"
						+"-----------------------------------------------------------------\r\n";			
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
		
		String message = "-----------------------------------------------------------------\r\n"
				+ "|         		 Account not opened yet!   		                |\r\n"
				+"-----------------------------------------------------------------\r\n";	 
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO account (account_number,account_type,balance,customer_id) VALUES (?,?,?,?)");
			ps.setInt(1, account.getAccount_number());
			ps.setString(2, "loan");
			ps.setInt(3, account.getBalance());
			ps.setInt(4, CustomerUseCases.cid);
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				message  =  "-----------------------------------------------------------------\r\n"
						+ "|          Your Laon Account Open Successfully ✔                |\r\n"
						+"-----------------------------------------------------------------\r\n";	
				
			}
			else
				throw new CustomerException("Insert Account details correctly");
			
					
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		} 

		return message;
	}
	
	@Override
	public int viewBalance(int acc_num) throws CustomerException{
		
		int amount = -1;
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps= con.prepareStatement("Select balance from account where account_number = ? AND is_deleted =0" );			
				
				ps.setInt(1, acc_num);
				
				ResultSet rs= ps.executeQuery();
				
				if(rs.next()) {
					amount=rs.getInt("balance");
				}
				else 
					throw new CustomerException("Enter Correct Account Number");
			
					
			} catch (SQLException e) {
				throw new CustomerException(e.getMessage());
			}

		return amount;
	}
	
	
	@Override
	public int depositMoney(int acc_no, int amt) throws CustomerException {
		
		int amount = -1;
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("update account set balance = balance + ? where account_number =? AND is_deleted =0");
			ps.setInt(1, amt);
			ps.setInt(2, acc_no);
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				amount = amt;
			PreparedStatement ps2 = con.prepareStatement("insert into transaction (account_number,deposit,withdraw,transaction_date) values (?,?,?,?)");
				ps2.setInt(1, acc_no);
				ps2.setInt(2, amount);
				ps2.setInt(3, 0);
				ps2.setDate(4, Date.valueOf(LocalDate.now()));
				
				int row2 = ps2.executeUpdate();
				
			}
			else
				throw new CustomerException("Account Number Wrong");
			
					
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		} 

		return amount;
	}
	

	@Override
	public int withdrawMoney(int amount, int account_number) throws CustomerException {
		
		int balance = viewBalance(account_number);
		
		if(balance > amount) {
		
			try (Connection con = DBUtil.provideConnection()){
				
				PreparedStatement ps = con.prepareStatement("update account set balance = balance - ? where account_number =? AND is_deleted =0");
				ps.setInt(1, amount);
				ps.setInt(2, account_number);
				
				int row = ps.executeUpdate();
				
				if(row > 0) {
					
				PreparedStatement ps2 = con.prepareStatement("insert into transaction (account_number,deposit,withdraw,transaction_date) values (?,?,?,?)");
					ps2.setInt(1, account_number);
					ps2.setInt(2, 0);
					ps2.setInt(3, amount);
					ps2.setDate(4, Date.valueOf(LocalDate.now()));
					
					int row2 = ps2.executeUpdate();
					
				}
				else
					throw new CustomerException("Account Number Wrong");
				
						
			} catch (SQLException e) {
				throw new CustomerException(e.getMessage());
			} 
			
			
			
		}
		else {
			throw new CustomerException("Insufficient Balance");
		}
		
		
		return amount;
	}

	@Override
	public String transferToAnotherAccount(int acc1, int amount, int acc2) throws CustomerException {
		
		String msg = "-----------------------------------------------------------------\r\n"
				+ "|          Enter Correct Account Number!			                |\r\n"
				+"-----------------------------------------------------------------\r\n";
				
		int blns = viewBalance(acc1);
		
		if(blns < amount) msg = "Insufficient Balance";
		
		if(blns > amount && checkAccount(acc1)) {
			
			depositMoney(acc2, amount);
			withdrawMoney(amount, acc1);
			
			msg ="-----------------------------------------------------------------------------\r\n"
					+ "|        Amount of \" + amount + \" successfully tranfered to Account Number \" + acc2		 |\r\n"
					+"----------------------------------------------------------------------------\r\n";
					
			
		}
		return msg;
	}
	
	
	private boolean checkAccount(int acc) {
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from account where account_number=?;");
			
			ps.setInt(1, acc);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
		
	}

	@Override
	public List<Transaction> transactionByDateRange(String startDate, String endDate, int acc_num) throws CustomerException {
		
		List<Transaction> list = new ArrayList<>();
		
		if(checkAccount(acc_num)) {
			
			try(Connection conn = DBUtil.provideConnection()) {
				PreparedStatement ps=conn.prepareStatement("select * from transaction where account_number=? AND transaction_date BETWEEN ? AND ? AND is_deleted =0");
				
				ps.setInt(1, acc_num);
				ps.setDate(2, Date.valueOf(startDate));
				ps.setDate(3, Date.valueOf(endDate));
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					
					Transaction tran = new Transaction();
					tran.setAccount_number(rs.getInt(1));
					tran.setDeposit(rs.getInt(2));
					tran.setWithdraw(rs.getInt(3));
					LocalDate d = LocalDate.parse(rs.getString(4));
					tran.setTransaction_date(d);
					tran.setIs_delete(rs.getBoolean(5));
					
					list.add(tran);
					
				}
				if(list.size()==0)
					throw new CustomerException("No Transaction Between " + startDate + " -- " + endDate);
				
			} catch (SQLException e) {
				throw new CustomerException(e.getMessage());
			}
		}
		else
			throw new CustomerException("Account does not exist!");
		
		return list;
	}

	@Override
	public String closeAccount(int acc_num) throws CustomerException {
		
		String msg = "Enter Correct Account Number!";
		
		if(checkAccount(acc_num)) {
		
			try(Connection conn = DBUtil.provideConnection()) {
				PreparedStatement ps=conn.prepareStatement("update account set is_close = true where account_number=? AND is_deleted =0");
				
				ps.setInt(1, acc_num);
				
				int row=ps.executeUpdate();
				
				if(row > 0) {
					msg = "Your Account is Closed";
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		
		}
	
		return msg;
		
	}

	@Override
	public String deleteAccount(int acc_num) throws CustomerException {
		String msg = "-----------------------------------------------------------------\r\n"
				+ "|          Enter Correct Account Number!			                |\r\n"
				+"-----------------------------------------------------------------\r\n";
		
		if(checkAccount(acc_num)) {
		
			try(Connection conn = DBUtil.provideConnection()) {
				PreparedStatement ps=conn.prepareStatement("update account set is_deleted = true where account_number=?;");
				
				ps.setInt(1, acc_num);
				
				int row=ps.executeUpdate();
				
				if(row > 0) {
					msg = "-----------------------------------------------------------------\r\n"
							+ "|          Your account is deleted successfully			    |\r\n"
							+"-----------------------------------------------------------------\r\n";
							
							
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		
		}
	
		return msg;
	}

	
	

}
