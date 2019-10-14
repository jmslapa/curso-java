package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		List<Employee> list = new ArrayList<>(); 
		
		System.out.print("How many employees wil be registred? ");
		int n = in.nextInt();
		
		for(int i = 0 ; i < n ; i++) {
			System.out.printf("Employee #%d:\n", i+1);
			System.out.print("Id: " );
			int id = in.nextInt();
			System.out.print("Name: ");
			in.nextLine();
			String name = in.nextLine();
			System.out.print("Salary: ");
			double salary = in.nextDouble();
			System.out.println();
			
			Employee employee = new Employee(id, name, salary);
			list.add(employee);
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = in.nextInt();
		System.out.print("Enter the percentage: ");
		double percentage = in.nextDouble();
		
		for(int i = 0 ; i < n ; i++) {
			if(list.get(i).getId() == id ) {
				list.get(i).salaryIncrease(percentage);
				break;
			}else if(i == n-1)
				System.out.println("The entered id does not exist");
		}
		
		System.out.println();
		System.out.println("List of employees:");
		for(int i = 0 ; i < n ; i++)
			System.out.println(list.get(i).toString());

		in.close();
	}

}
