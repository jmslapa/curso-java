package entities;

public class Account {
	// CONSTANTS
	private static final double TAX = 5;
	
	// ATTRIBUTES
	private int accountNumber;
	private String accountHolder;
	private double accountBalance;

	// BUILDERS
	public Account(int accountNumber, String accountHolder) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
	}

	
	public Account(int accountNumber, String accountHolder, double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.accountBalance = accountBalance;
	}

	// METHODS
	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountHolder() {
		return accountHolder;
	}


	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}


	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void addFunds(double funds) {
		accountBalance += funds;
	}
	
	public void withdrawFunds(double funds) {
		accountBalance -= funds + TAX;
	}

	public String toString() {
		return "Account " + 
				accountNumber + 
				", Holder: " + 
				accountHolder + 
				", Balance: $"
				+ String.format("%.2f", accountBalance);
	}
	
	
		
}
