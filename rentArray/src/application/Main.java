package application;

import java.util.Scanner;
import entities.Tenant;

public class Main {

	private static final int MAX = 10;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Tenant[] array = new Tenant[MAX];
		int n;

		System.out.println("Enter the number of rooms to be rent");
		n = in.nextInt();

		for (int i = 0; i < n; i++) {

			in.nextLine();
			System.out.println("Enter the following tanant data:");
			System.out.println("");
			System.out.print("Tenant name: ");
			String name = in.nextLine();
			System.out.print("Tenant email:");
			String email = in.nextLine();
			System.out.print("Rented room number: ");
			int roomNumber = in.nextInt();

			array[roomNumber] = new Tenant(name, email, roomNumber);
			System.out.println("");
		}

		System.out.println("------------------------------------------------------------------------------------");
		for (Tenant obj : array) {
			if (obj != null)
				System.out.println(obj.toString());
		}

		in.close();
	}

}
