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
import com.masai.dto.CustomerAccount;
import com.masai.dto.Transaction;
import com.masai.exception.AccountantException;
import com.masai.exception.CustomerException;
import com.masai.ui.CustomerUI;
import com.masai.util.DBUtil;

public class AccountantDaoImpl implements AccountantDao{

	@Override
	public List<Customer> viewAllCustomers() throws AccountantException {
		
		List<Customer> customers = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM customer where is_deleted =0 ");
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer cus = new Customer();
				cus.setCustomer_id(rs.getInt(1));
				cus.setFirst_name(rs.getString(2));
				cus.setLast_name(rs.getString(3));
				cus.setMobile(rs.getString(4));
				cus.setAddress(rs.getString(5));
				cus.setUsername(rs.getString(6));
				cus.setPassword(rs.getString(7));
				cus.setIs_deleted(rs.getBoolean(8));
				
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
			
			PreparedStatement ps = con.prepareStatement("SELECT c.customer_id,c.first_name,c.last_name,c.mobile,c.address,a.account_number,a.account_type,a.balance,a.status from customer c INNER JOIN account a ON c.customer_id = a.customer_id");
						
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				caccount = new CustomerAccount();
				caccount.setCustomer_id(rs.getInt(1));
				caccount.setFirst_name(rs.getString(2));
				caccount.setLast_name(rs.getString(3));
				caccount.setMobile(rs.getString(4));
				caccount.setAddress(rs.getString(5));
				caccount.setAccount_number(rs.getInt(6));
				caccount.setAccount_type(rs.getString(7));
				caccount.setBalance(rs.getInt(8));
				caccount.setStatus(rs.getString(9));	
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
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM account where is_deleted =0");
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account account = new Account();
				account.setAccount_number(rs.getInt(1));
				account.setAccount_type(rs.getString(2));
				account.setBalance(rs.getInt(3));
				account.setCustomer_id(rs.getInt(4));
				account.setStatus(rs.getString(5));
				account.setIs_close(rs.getBoolean(6));
				account.setIs_deleted(rs.getBoolean(7));
				
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
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM account where account_number = ? AND  is_deleted =0");
			ps.setInt(1, acc_num);
						
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				account = new Account();
				account.setAccount_number(rs.getInt(1));
				account.setAccount_type(rs.getString(2));
				account.setBalance(rs.getInt(3));
				account.setCustomer_id(rs.getInt(4));
				account.setStatus(rs.getString(5));
				account.setIs_close(rs.getBoolean(6));
				account.setIs_deleted(rs.getBoolean(7));
			}
			
			else
				throw new AccountantException("No account available with account number : " + acc_num);
					
		} catch (SQLException e) {
			throw new AccountantException(e.getMessage());
		} 
	
		return account;
	}

	
	@Override
	public String addAccount(Account account) throws AccountantException {
		
		String message="Not Added!";
		
		try(Connection conn= DBUtil.provideConnection()) {
		 
		 PreparedStatement ps=conn.prepareStatement("insert into account(account_type,balance,customer_id) values(?,?,?)");
		 ps.setString(1, account.getAccount_type());
		 ps.setInt(2, account.getBalance());
		 ps.setInt(3, account.getCustomer_id());
		 
	    
 
		int x=ps.executeUpdate();
		 
		 if(x > 0) {
			 System.out.println("Account added sucessfully..!");
		 }else
			 System.out.println("Inserted data is not correct");
		 
		}catch(SQLException e) {
			throw new AccountantException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String changeStatusToInoperative() throws AccountantException {
		String message="No account found!";
		
		try(Connection conn= DBUtil.provideConnection()) {
		 
		 PreparedStatement ps=conn.prepareStatement("UPDATE account c JOIN transaction t ON c.account_number = t.account_number SET c.status = 'inoperative' WHERE (t.transaction_date < DATE_SUB(NOW(), INTERVAL 24 MONTH)) AND c.is_deleted =0");
		 
		int x=ps.executeUpdate();
		 
		 if(x > 0) {
			 message = x + "accounts converted into inoperative account";
		 }
		 
		}catch(SQLException e) {
			throw new AccountantException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Account> viewInoperativeAccounts() throws AccountantException {
		List<Account> accounts = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM account where status =  ? AND is_deleted =0");
			ps.setString(1, "inoperative");
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account account = new Account();
				account.setAccount_number(rs.getInt(1));
				account.setAccount_type(rs.getString(2));
				account.setBalance(rs.getInt(3));
				account.setCustomer_id(rs.getInt(4));
				account.setStatus(rs.getString(5));
				account.setIs_close(rs.getBoolean(6));
				account.setIs_deleted(rs.getBoolean(7));
				
				accounts.add(account);
				
			}
			
			if(accounts.size() == 0)
				throw new AccountantException("No inoperative accounts available");
					
		} catch (SQLException e) {
			throw new AccountantException(e.getMessage());
		} 
	
		return accounts;
	}

	@Override
	public List<Account> viewClosedAccounts() throws AccountantException {
		List<Account> accounts = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM account where is_close =  ? AND is_deleted =0");
			ps.setBoolean(1, true);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account account = new Account();
				account.setAccount_number(rs.getInt(1));
				account.setAccount_type(rs.getString(2));
				account.setBalance(rs.getInt(3));
				account.setCustomer_id(rs.getInt(4));
				account.setStatus(rs.getString(5));
				account.setIs_close(rs.getBoolean(6));
				account.setIs_deleted(rs.getBoolean(7));
				
				accounts.add(account);
				
			}
			
			if(accounts.size() == 0)
				throw new AccountantException("No inoperative accounts available");
					
		} catch (SQLException e) {
			throw new AccountantException(e.getMessage());
		} 
	
		return accounts;
	}
	
	
	
	@Override
	public List<Transaction> transactionByDateRange(String startDate, String endDate) throws CustomerException {
		
		List<Transaction> list = new ArrayList<>();
		
			
			try(Connection conn = DBUtil.provideConnection()) {
				PreparedStatement ps=conn.prepareStatement("select * from transaction where transaction_date BETWEEN ? AND ? AND is_deleted =0");
				
				ps.setDate(1, Date.valueOf(startDate));
				ps.setDate(2, Date.valueOf(endDate));
				
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
		
		return list;
	}
	

	@Override
	public List<Transaction> transactionMoreThan49k() throws AccountantException {
		List<Transaction> list = new ArrayList<>();
		
			try(Connection conn = DBUtil.provideConnection()) {
				PreparedStatement ps=conn.prepareStatement("select * from transaction where deposit > ? OR withdraw > ? AND is_deleted =0");
				
				ps.setInt(1, 49999);
				ps.setInt(2, 49999);
				
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
					throw new AccountantException("No transaction is more than 49999");
				
			} catch (SQLException e) {
				throw new AccountantException(e.getMessage());
			}
	
		
		return list;
	}
	
	
	
}
