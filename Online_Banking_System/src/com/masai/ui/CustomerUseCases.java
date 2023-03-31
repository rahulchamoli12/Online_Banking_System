package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.dto.Account;
import com.masai.dto.Customer;
import com.masai.dto.Transaction;
import com.masai.exception.CustomerException;

public class CustomerUseCases {
	
	public static int cid;
	
	 static void Signup(Scanner sc) {
		
		System.out.print("Enter First name : ");
		String f_name = sc.nextLine();
		
		System.out.print("Enter Last name : ");
		String l_name = sc.nextLine();
		
		System.out.print("Enter Mobile : ");
		String mobile = sc.nextLine();
		
		System.out.print("Enter Address : ");
		String address = sc.nextLine();
		
		System.out.print("Enter Username : ");
		String username = sc.nextLine();
		
		System.out.print("Enter Password : ");
		String password = sc.nextLine();
		
		Customer customer = new Customer();
		customer.setFirst_name(f_name);
		customer.setLast_name(l_name);
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
				try {
					CustomerDaoImpl.account_number();
				} catch (Exception e) {
					// TODO: handle exception
				}
				CustomerUI.customerMenu(sc);
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
			
	 }
	 
	 static void UpdateCustomerDetails(Scanner sc) {
		 
		 System.out.print("Enter First name : ");
			String f_name = sc.nextLine();
			
			System.out.print("Enter Last name : ");
			String l_name = sc.nextLine();
			
			System.out.print("Enter Mobile : ");
			String mobile = sc.nextLine();
			
			System.out.print("Enter Address : ");
			String address = sc.nextLine();
			
			Customer customer = new Customer();
			customer.setFirst_name(f_name);
			customer.setLast_name(l_name);
			customer.setMobile(mobile);
			customer.setAddress(address);
			
			CustomerDao dao = new CustomerDaoImpl();
			try {
				String message = dao.updateCustomerDetails(f_name,l_name, mobile, address,CustomerUseCases.cid);
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
		 
		 						
			System.out.print("Enter Balance to open the account : ");
			int balance = Integer.parseInt(sc.nextLine());
			
			Account account = new Account();
//			account.setAccount_number(account_number);/
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
								
			System.out.print("Enter Balance to open the account : ");
			int balance = Integer.parseInt(sc.nextLine());
			
			Account account = new Account();
//			account.setAccount_number(account_number);
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
	 
	 static void DepositMoney(Scanner sc) {
		 
		 		 
			System.out.print("Enter Deposit Amount : ");
			int amt = Integer.parseInt(sc.nextLine());
			
			CustomerDao dao = new CustomerDaoImpl();
			
			try {
				int amount = dao.depositMoney(UIMain.account_number, amt);
				System.out.println("-----------------------------------------------------------------\r\n"
						+ "|	Amount of " + amount + " Successfully Deposited in your Account : "  + "	|\r\n"
						+"-----------------------------------------------------------------\r\n");
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
			
	 }
	 
	 
	 static void ViewBalance(Scanner sc) {
				 
		CustomerDao dao = new CustomerDaoImpl();
			
			try {
				int amount = dao.viewBalance(UIMain.account_number);
				System.out.println("Your Current Balance is : " + amount);
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
		 
	 }
	 
	 
	 static void WithdrawMoney(Scanner sc) {
		 
		 		 
			System.out.print("Enter Withdraw Amount : ");
			int amt = Integer.parseInt(sc.nextLine());
			
			CustomerDao dao = new CustomerDaoImpl();
			
			try {
				int amount = dao.withdrawMoney(amt,UIMain.account_number);
				System.out.println("-----------------------------------------------------------------\r\n"
						+ "|	Amount of " + amount + " Successfully Withdrwaing from your account : " + "	|\r\n"
						+"-----------------------------------------------------------------\r\n" );
				System.out.println("Your Remaining Balance Is : " + dao.viewBalance(UIMain.account_number));
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
			
	 }
	 
	 static void TransferToAnotherAccount(Scanner sc) {
		 		 
			System.out.print("Enter Amount : ");
			int amt = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter Payee Account Number : ");
			int ac_num2 = Integer.parseInt(sc.nextLine());
			
			CustomerDao dao = new CustomerDaoImpl();
			
			try {
				String msg = dao.transferToAnotherAccount(UIMain.account_number, amt, ac_num2);
				System.out.println(msg);
				System.out.println("-----------------------------------------------------------------\r\n"
						+ "|	Your Remaining Balance Is : " + dao.viewBalance(UIMain.account_number)  +  "	|\r\n"
						+"-----------------------------------------------------------------\r\n");
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
		 
	 }
	 
	 static void TransactionByDateRange(Scanner sc) {
		 
		 	 
			System.out.print("Enter Start Date (yyyy-mm-dd) : ");
			String s_date = sc.nextLine();
			
			System.out.print("Enter End Date (yyyy-mm-dd) : ");
			String e_date = sc.nextLine();
			
			CustomerDao dao = new CustomerDaoImpl();
			
			try {
				List<Transaction> list = dao.transactionByDateRange(s_date, e_date, UIMain.account_number);
				list.forEach(s -> System.out.println(s) );
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			} 
	 }
	 
	 
	 static void CloseAccount(Scanner sc) {
		 
		 System.out.print("Enter Your Account Number : ");
		int ac_num1 = Integer.parseInt(sc.nextLine());
		
		CustomerDao dao = new CustomerDaoImpl();
		if(ac_num1==UIMain.account_number) {
			
		
		try {
			
			String msg = dao.closeAccount(ac_num1);
			System.out.println(msg);
			System.out.println("Thank you for using our application");
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
		}else {
			System.out.println("Wrong Account Number");
			CloseAccount(sc);
		}
		 
	 }
	 
	 static void DeleteAccount(Scanner sc) {
		 
		 System.out.print("Enter Your Account Number : ");
		int ac_num1 = Integer.parseInt(sc.nextLine());
		
		CustomerDao dao = new CustomerDaoImpl();
		
		if(ac_num1==UIMain.account_number) {
		
		try {
			String msg = dao.deleteAccount(ac_num1);
			System.out.println(msg);
			System.out.println("Thank you for using our application");
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		} 
		}
		else {
			System.out.println("Wrong Account Number");
			DeleteAccount(sc);
		}
		
	 }
	 
	
}
