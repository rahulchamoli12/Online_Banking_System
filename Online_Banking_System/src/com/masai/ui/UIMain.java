package com.masai.ui;

import java.util.Scanner;

public class UIMain {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("0. Exit");
			System.out.println("1. Login as a Accountant");
			System.out.println("2. Signup as a Customer");
			System.out.println("3. Login as a Customer");
			System.out.print("Enter Selection ");
			choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
				case 1:
					System.out.print("Enter accountant username : ");
					String username = sc.nextLine();
					System.out.print("Enter accountant password : ");
					String password = sc.nextLine();
					
					if(username.equals("admin") && password.equals("admin"))
						AccountantUI.adminMenu(sc);
					else
						System.out.println("Wrong Credentials ❌");
					break;
				case 2:
					CustomerUseCases.Signup(sc);
					break;
				case 3:
				CustomerUseCases.Login(sc);
					break;
				case 0:
					System.out.println("Thank you for using this application");
					break;
				default:
					System.out.println("Invalid Selection please try again later");
			}
			
		}while(choice != 0);
		sc.close();
	}
	
	
	
}
