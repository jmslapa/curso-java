package application;

import entities.Account;
import java.util.Scanner;
import java.util.Locale;

public class BankAccount {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		char answer;
		int accountNumber;
		String accountHolder;
		double funds;
		
		Account account = null;
		
		System.out.println("Enter the following data:");
		
		System.out.print("Account Number: ");
		accountNumber = sc.nextInt();
		System.out.print("Account Holder: ");
		sc.nextLine();
		accountHolder = sc.nextLine();
		
		System.out.print("Want to make an inital deposit? ");		
		
		do {
			answer = sc.next().charAt(0);
			
			if(answer == 'y') {
				System.out.print("Initial deposit: ");
				funds = sc.nextDouble();
				
				account = new Account(accountNumber, accountHolder, funds);
				
			}else if(answer == 'n') {
				account = new Account(accountNumber, accountHolder);
			}else {
				System.out.println("The answer must be 'y' to 'yes' or 'n' to 'no'. Please try again.");
			}
			
		} while(answer != 'y' && answer != 'n');
		
		System.out.printf("\nAccount data:\n%s\n\n", account.toString());
		
		System.out.print("Enter a deposit value: ");
		funds = sc.nextDouble();
		account.addFunds(funds);
		System.out.printf("Updated data:\n%s\n\n", account.toString());
		
		System.out.print("Enter a withdraw value: ");
		funds = sc.nextDouble();
		account.withdrawFunds(funds);
		System.out.printf("Updated data:\n%s\n\n", account.toString());
		
		sc.close();
	}

}
