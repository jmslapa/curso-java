package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = in.nextInt();
		for(int i = 1 ; i <= n ; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char answer = in.next().charAt(0);
			System.out.print("Name: ");
			in.nextLine();
			String name = in.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = in.nextDouble();
			if(answer == 'i') {
				System.out.print("Health spendings: ");
				double healthSpendings = in.nextDouble();
				list.add(new Individual(name, anualIncome, healthSpendings));
			}else {
				System.out.print("Number of employees: ");
				int employeesQuantity = in.nextInt();
				list.add(new Company(name, anualIncome, employeesQuantity));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		double sum = 0;
		for(TaxPayer obj : list) {
			System.out.println(obj.toString());
			sum += obj.tax();
		}
		System.out.println();
		System.out.print("TOTAL TAXES: $");
		System.out.printf("%.2f\n", sum);
		
		in.close();
	}
}
