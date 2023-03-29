package com.masai.ui;

import java.util.Scanner;

public class AccountantUI {
	
	static void adminMenu(Scanner sc) {
		
		int choice = 0;
		System.out.println("Welcome Admin");
		
		do {
			System.out.println("1. View all customers");
			System.out.println("2. View customer details by customer id");
			System.out.println("3. View all accounts");
			System.out.println("4. View account details by account number");
			System.out.println("5. Change the status of account from active to inoperative if no trsnaction for last 24 months");
			System.out.println("6. View all inoperative accounts");
			System.out.println("7. View all closed accounts");
			System.out.println("8. View transaction report for a day range for all accounts.");
			System.out.println("9. View all high magnitude transaction for a day i.e. more than 49999 is transferred");
			System.out.println("0. Logout");
			System.out.println("Enter the choice : ");
			
			 choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:
				AccountantUseCases.ViewAllCustomers();
				System.out.println("==================");
				break;
			case 2 :
				AccountantUseCases.ViewByCustomerID(sc);
				System.out.println("==================");
				break;
			case 3 :
				AccountantUseCases.ViewAllAccounts();
				System.out.println("==================");
				break;
			case 4 :
				AccountantUseCases.ViewAccountByAccountNumber(sc);
				System.out.println("==================");
				break;
			default :
				System.out.println();
			}
			
			
		}while(choice != 0);
		
	}
	
}
