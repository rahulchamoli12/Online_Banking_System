package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.CustomerDaoImpl;

public class CustomerUI {
	
	public static String cu_name;
	
		
	static void customerMenu(Scanner sc) {
			
		System.out.println("Welcome " + cu_name);
		int choice = 0;
		boolean f = true;;
		if(UIMain.account_number == 0) {
			System.out.println("Create your account");
			System.out.println("1. Open Saving Account");
			System.out.println("2. Open Loan Account");
			int ch = 0;
			try {
				 ch = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter correct option");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				
			}
			switch(ch) {
			case 1 :
				CustomerUseCases.OpenSavingsAccount(sc);
				break;
			case 2 : 
				CustomerUseCases.OpenLoanAccount(sc);
				break;
			default :
				System.out.println("Enter Valid Option !");
				break;
			}
			try {
				CustomerDaoImpl.account_number();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else {
			System.out.println("-----------------------------------------------------------------\r\n"
					+ "|		Your Account Number : \" + "+UIMain.account_number+" 		|\r\n"
					+"-----------------------------------------------------------------\r\n");
		
		}
		
		while(f) {
//			System.out.println("1. Open Account");
//			System.out.println("2. Update account details");
//			System.out.println("3. Update password");
//			System.out.println("4. Deposit money");
//			System.out.println("5. Withdraw money");
//			System.out.println("6. Check Transaction History");
//			System.out.println("7. Transfer money to another account");
//			System.out.println("8. close the account");
//			System.out.println("9. Delete account");
//			System.out.println("10. Check Balance");
//			System.out.println("0. Logout");
//			System.out.println("Enter the choice : ");
			
			
			System.out.println("-----------------------------------------------------------------\r\n"
					+ "| 1. Open Account \r\n"
					+ "| 2. Update Account Details \r\n"
					+ "| 3. Update Password \r\n"
					+ "| 4. Deposit Money \r\n"
					+ "| 5. Withdraw Money \r\n"
					+ "| 6. Check Transaction History \r\n"
					+ "| 7. Transfer to Another Account \r\n"
					+ "| 8. Close Account \r\n"
					+ "| 9. Delete Account \r\n"
					+ "| 10. Check Balance \r\n"
					+ "| 0. Logout \r\n"
					+  "-----------------------------------------------------------------\r\n"
					+ "Please enter your choice:");
			
			
			
			
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter correct option");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				continue;
			}
			switch(choice) {
			case 1:
				System.out.println("1. Open Saving Account");
				System.out.println("2. Open Loan Account");
				int ch = 0;
				try {
					 ch = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					System.out.println("Please enter correct option");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					continue;
				}
				switch(ch) {
				case 1 :
					CustomerUseCases.OpenSavingsAccount(sc);
					break;
				case 2 : 
					CustomerUseCases.OpenLoanAccount(sc);
					break;
				default :
					System.out.println("Enter Valid Option !");
					break;
				}
				try {
					CustomerDaoImpl.account_number();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			break;

			case 2 :
				CustomerUseCases.UpdateCustomerDetails(sc);
				break;
			case 3 :
				CustomerUseCases.UpdatePassword(sc);
				break;
			case 4 :
				CustomerUseCases.DepositMoney(sc);
				break;
			case 5 :
				CustomerUseCases.WithdrawMoney(sc);
				break;
			case 6 :
				CustomerUseCases.TransactionByDateRange(sc);
				break;
			case 7 :
				CustomerUseCases.TransferToAnotherAccount(sc);
				break;
			case 8 :
				CustomerUseCases.CloseAccount(sc);
				f = false;
				break;
			case 9 :
				CustomerUseCases.DeleteAccount(sc);
				f = false;
				break;
			case 10 :
				CustomerUseCases.ViewBalance(sc);
				break;
			case 0 :
				System.out.println("Your Logged Out");
				f = false;
				UIMain.account_number = 0;
				break;
			default :
				System.out.println("Enter Correct Input");
			}	
		}
		
	}
	
	
}
