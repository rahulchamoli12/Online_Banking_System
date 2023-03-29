package com.masai.ui;

import java.util.Scanner;

public class CustomerUI {
	
		
	static void customerMenu(Scanner sc) {
		
		System.out.println("Welcome ");
		int choice = 0;
		
		do {
			System.out.println("1. Open Account");
			System.out.println("2. Update account details");
			System.out.println("3. Update password");
			System.out.println("4. Deposit money");
			System.out.println("5. Withdraw money");
			System.out.println("6. Check Transaction History");
			System.out.println("7. Transfer money to another account");
			System.out.println("8. close the account");
			System.out.println("9. Delete account");
			System.out.println("0. Logout");
			System.out.println("Enter the choice : ");
			
			 choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:
				System.out.println("1. Open Saving Account");
				System.out.println("2. Open Loan Account");
				int ch = Integer.parseInt(sc.nextLine());
				switch(ch) {
				case 1 :
					CustomerUseCases.OpenSavingsAccount(sc);
					System.out.println("====================");
					break;
				case 2 : 
					CustomerUseCases.OpenLoanAccount(sc);
					System.out.println("====================");
					break;
				default :
					System.out.println("Enter Valid Option !");
					break;
				}
				break;
			case 2 :
				CustomerUseCases.UpdateCustomerDetails(sc);
				break;
			case 3 :
				CustomerUseCases.UpdatePassword(sc);
				break;
			default :
				System.out.println("Your Logged Out");
			}
			
			
		}while(choice != 0);
		sc.close();
		
	}
	
	
}
