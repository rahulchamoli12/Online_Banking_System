package com.masai.ui;

import java.util.Scanner;

public class AccountantUI {

	static void adminMenu(Scanner sc) {

		int choice = 0;
		System.out.println("Welcome Accountant");
		boolean f = true;

		while (f) {
			System.out.println("1. Logout");
			System.out.println("2. View all customers");
			System.out.println("3. View customer details by customer id");
			System.out.println("4. View all accounts");
			System.out.println("5. View account details by account number");
			System.out.println(
					"6. Change the status of account from active to inoperative if no trsnaction for last 24 months");
			System.out.println("7. View all inoperative accounts");
			System.out.println("8. View all closed accounts");
			System.out.println("9. View transaction report for a day range for all accounts.");
			System.out.println("10. View all high magnitude transaction for a day i.e. more than 49999 is transferred");
			//System.out.println("0. Logout");
			System.out.println("Enter the choice : ");

			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter correct option");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				continue;
			}
			switch (choice) {
			case 1:
				System.out.println("Logged Out");
				f = false;
				break;

			case 2:
				AccountantUseCases.ViewAllCustomers();
				System.out.println("==================/r/n");
				break;

			case 3:
				AccountantUseCases.ViewByCustomerID(sc);
				System.out.println("==================");
				break;

			case 4:
				AccountantUseCases.ViewAllAccounts();
				System.out.println("==================");
				break;
			case 5:
				AccountantUseCases.ViewAccountByAccountNumber(sc);
				System.out.println("==================");
				break;
			case 6:
				AccountantUseCases.ChangeStatusToInoperative();
				System.out.println("==================");
				break;
			case 7:
				AccountantUseCases.ViewInoperativeAccounts();
				System.out.println("==================");
				break;
			case 8:
				AccountantUseCases.viewClosedAccounts();
				System.out.println("==================");
				break;
			case 9:
				AccountantUseCases.TransactionByDateRange(sc);
				System.out.println("==================");
				break;
			case 10:
				AccountantUseCases.transactionMoreThan49k();
				System.out.println("==================");
				break;
			
			default:
				System.out.println("Enter Correct Input");
				}

		} 
//		


	}

}
