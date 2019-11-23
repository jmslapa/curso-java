package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.InstallmentService;
import services.PaypalPaymentService;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		sc.nextLine();
		String date = sc.nextLine();
		System.out.print("Contract Value: ");
		Double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, sdf.parse(date), totalValue);
		
		System.out.print("Enter the number of installments: ");
		int numberOfInstallments = sc.nextInt();
		
		InstallmentService installmentService = new InstallmentService(numberOfInstallments,new PaypalPaymentService());
				
		installmentService.processTheContract(contract);
		
		System.out.println("Installments:");
		for(Installment installment : installmentService.getInstallments()) {
			System.out.println(installment);
		}
		
		sc.close();
	}

}
