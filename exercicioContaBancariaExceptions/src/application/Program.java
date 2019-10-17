package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Account;
import model.exception.WithdrawalException;

public class Program {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		try {
			System.out.println("Enter account data:");
			System.out.print("Account number: ");
			int number = in.nextInt();
			System.out.print("Account Holder: ");
			in.nextLine();
			String holder = in.nextLine();
			System.out.print("Initial deposit: $");
			double balance = in.nextDouble();
			System.out.print("Withdraw limit: $");
			double withdrawLimit = in.nextDouble();
			
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: $");
			double amount = in.nextDouble();	
			
			account.withdraw(amount);
			
			System.out.println();
			System.out.println("New balance: $" + String.format("%.2lf", account.getBalance()));
			
		}catch(InputMismatchException e){
			System.out.println("Input error: Invalid input");
		}catch(WithdrawalException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("UNEXPECTED FATAL ERROR");
		}
		
		in.close();
	}

}
