package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		List<String> coursesPaths = new ArrayList<>();
		
		System.out.print("Enter the number of courses: ");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0 ; i < n ; i++) {
			System.out.print("Enter the path of course " + (i+1) + ": ");
			coursesPaths.add(sc.nextLine());
		}

		Set<String> students = new TreeSet<>();
		
		for(String path : coursesPaths) {
			
			File file = new File(path);
			
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {

				String line = br.readLine();
				while (line != null) {
					students.add(line);
					line = br.readLine();
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\nNumber of Students: " + students.size());
		
		System.out.println();
		for(String student : students) {
			System.out.println(student);
		}
		
		sc.close();
	}
}
