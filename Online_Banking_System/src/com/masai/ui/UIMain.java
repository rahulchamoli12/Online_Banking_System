package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;

public class UIMain {
	
	// Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
    
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset
    
 // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
	

	
	
//	for getting account number of customer
	public static int account_number;

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println(CYAN_BOLD+"******************************************************");
		System.out.println( "	  Welcome To Online Banking System");
		System.out.println("******************************************************"+RESET);
		System.out.println("");
		int choice = 0;
		boolean f = true;
		while(f){
			System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
			System.out.println("1. Login as a Accountant");
			System.out.println("2. Signup as a Customer");
			System.out.println("3. Login as a Customer");
			System.out.println("0. Exit");
			System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
			System.out.println();
			System.out.print(PURPLE_BOLD+"Enter Selection "+RESET);
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("");
				System.out.println(RED_BOLD+"Please enter correct option"+RESET);
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
						System.out.println("");
						System.out.println(RED_BOLD+"Wrong Credentials ❌"+RESET);
						System.out.println("");
					break;
				case 2:
					
					CustomerUseCases.Signup(sc);
					
					break;
				case 3:
					
				CustomerUseCases.Login(sc);
				
					break;
				case 0:
					System.out.println( "Thank you for using this application");
					f = false;
					break;
				default:
					System.out.println("");
					System.out.println(RED_BOLD+"Invalid Selection please try again "+RESET);
					System.out.println("");
					
			}
			
		}
		sc.close();
	}
	
	
	
}
