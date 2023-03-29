package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.dto.Account;
import com.masai.dto.Customer;
import com.masai.exception.CustomerException;

public class CustomerUseCases {
	
	public static int cid;
	
	 static void Signup(Scanner sc) {
		
		System.out.print("Enter name : ");
		String name = sc.nextLine();
		
		System.out.print("Enter Mobile : ");
		String mobile = sc.nextLine();
		
		System.out.print("Enter Address : ");
		String address = sc.nextLine();
		
		System.out.print("Enter Username : ");
		String username = sc.nextLine();
		
		System.out.print("Enter Password : ");
		String password = sc.nextLine();
		
		Customer customer = new Customer();
		customer.setName(name);
		customer.setMobile(mobile);
		customer.setAddress(address);
		customer.setUsername(username);
		customer.setPassword(password);
		
		CustomerDao dao = new CustomerDaoImpl();
		
		 
		try {
			String message = dao.signUpAsACustomer(customer);
			System.out.println(message);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
			
	}
	 
	 
	 
	 static void Login(Scanner sc) {
		 	System.out.print("Enter Username : ");
			String username = sc.nextLine();
			
			System.out.print("Enter Password : ");
			String password = sc.nextLine(); 
			
			CustomerDao dao = new CustomerDaoImpl();
			
			try {
				String message = dao.loginAsACustomer(username, password);
				System.out.println(message);
				CustomerUI.customerMenu(sc);
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
			
	 }
	 
	 static void UpdateCustomerDetails(Scanner sc) {
		 
		 	System.out.print("Enter name : ");
			String name = sc.nextLine();
			
			System.out.print("Enter Mobile : ");
			String mobile = sc.nextLine();
			
			System.out.print("Enter Address : ");
			String address = sc.nextLine();
			
			Customer customer = new Customer();
			customer.setName(name);
			customer.setMobile(mobile);
			customer.setAddress(address);
			
			CustomerDao dao = new CustomerDaoImpl();
			try {
				String message = dao.updateCustomerDetails(name, mobile, address,CustomerUseCases.cid);
				System.out.println(message);
				CustomerUI.customerMenu(sc);
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
		 
	 }
	 
	 
	static void UpdatePassword(Scanner sc) {
		
				
		System.out.print("Enter Old Password : ");
		String old_password = sc.nextLine(); 
		
		System.out.print("Enter New Password : ");
		String new_password = sc.nextLine(); 
		
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
			String message = dao.updatePassword(old_password,new_password,CustomerUseCases.cid);
			System.out.println(message);
			CustomerUI.customerMenu(sc);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
	}
	 
	 static void OpenSavingsAccount(Scanner sc) {
		 
		 	System.out.print("Enter account_number : ");
			int account_number = Integer.parseInt(sc.nextLine());
						
			System.out.print("Enter balance : ");
			int balance = Integer.parseInt(sc.nextLine());
			
			Account account = new Account();
			account.setAccount_number(account_number);
			account.setAccount_type("saving");
			account.setBalance(balance);
			account.setCustomer_id(cid);
			
			CustomerDao dao = new CustomerDaoImpl();
		 
			try {
				String message = dao.openSavingsAccount(account);
				System.out.println(message);
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
		 
	 }
	 
	 static void OpenLoanAccount(Scanner sc) {
		 
		 	System.out.print("Enter account_number : ");
			int account_number = Integer.parseInt(sc.nextLine());
						
			System.out.print("Enter balance : ");
			int balance = Integer.parseInt(sc.nextLine());
			
			Account account = new Account();
			account.setAccount_number(account_number);
			account.setAccount_type("loan");
			account.setBalance(balance);
			account.setCustomer_id(cid);
			
			CustomerDao dao = new CustomerDaoImpl();
		 
			try {
				String message = dao.openLoanAccount(account);
				System.out.println(message);
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
}
