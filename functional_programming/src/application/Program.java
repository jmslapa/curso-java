package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter full file path: ");
		File file = new File(sc.nextLine());
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("Enter Salary: ");
		Double salary = sc.nextDouble();
		
		List<String> emails = list.stream()
				.filter(e -> e.getSalary() > salary)
				.map(e -> e.getEmail())
				.sorted((a, b) -> a.compareToIgnoreCase(b))
				.collect(Collectors.toList());
		
		Double sum = list.stream()
				.filter(e -> e.getName().toUpperCase().charAt(0) == 'M')
				.map(e -> e.getSalary())
				.reduce(0.0, (x, y) -> x + y);
		
		
		System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ":");
		emails.forEach(System.out::println);
		System.out.print("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));
		
		
		sc.close();
	}
}
