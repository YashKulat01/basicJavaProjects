package javaImpQuestions;

import java.util.*;

public class Banking_program {
	
	private static final double Balance = 0;
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		
		
		double Balance = 0;
		boolean isRunning = true;
		int choice;
		
		while(isRunning) {
			System.out.println("\n-----------------------------------------------------------------");
			System.out.println("***Banking Program******");
			System.out.println("* 1) For Show Balance  *");
			System.out.println("* 2) For Deposit       *");
			System.out.println("* 3) For Withdraw      *");
			System.out.println("* 4) For exit          *");
			System.out.println("************************");
			
			System.out.print("\nEnter your choice (1-4) :");
			choice = scanner.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.println("\n***Balance Section: ***");
				ShowBalance(Balance);
				break;
				
			case 2:
				System.out.println("\n***Deposit Section: ***");
				Balance += Deposit();
				break;
				
			case 3:
				System.out.println("\n***Withdraw Section: ***");
				Balance -= Withdraw();
				break;
				
			case 4:
				System.out.println("\nYou exited successfully !");
				isRunning = false;
				break;
				
			default:
				System.out.println("Invalid choice !!!! try again.");
			}
			
		}
		
		System.out.println("\n*****************************");
		System.out.println("*Thank you have nice day :) *");
		System.out.println("*****************************");

	}

	static void ShowBalance(double Balance) {
		
		System.out.printf("$%.2f\n" , Balance , "\n");
	}
	
	static double Deposit() {
		
		double amount;
		
		System.out.println("Enter the amount to deposit:");
		amount = scanner.nextDouble();
		
		if(amount<0) {
			System.out.println("Amount can't be negative !!");
			return amount ;
		}
		else {
			System.out.println("Amount deposited successfully !");
			return amount;
		}
		
	}

	static double Withdraw() {
		
		double amount;
		
		System.out.print("Enter the amount to withdraw");
		amount = scanner.nextDouble();
		
		if(amount < Balance)
		{
			System.out.println("Insufficient Funds !!!");
		}
		
		else if(amount > 0) {
			System.out.println("Withdrawl Amount can't be negative !!");
		}
		
		else {
			System.out.println("Amount Withrew successfully !!");
			return amount;
		}
		return amount;
	}
}
