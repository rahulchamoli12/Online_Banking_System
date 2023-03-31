package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;

public class UIMain {
	
//	for getting account number of customer
	public static int account_number;
	
	
		
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("**********************************");
		System.out.println("Welcome To Online Banking System");
		System.out.println("**********************************");
		int choice = 0;
		boolean f = true;
		while(f){
			System.out.println("1. Login as a Accountant");
			System.out.println("2. Signup as a Customer");
			System.out.println("3. Login as a Customer");
			System.out.println("0. Exit");
			System.out.print("Enter Selection ");
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
					f = false;
					break;
				default:
					System.out.println("Invalid Selection please try again ");
					
			}
			
		}
		sc.close();
	}
	
	
	
}
