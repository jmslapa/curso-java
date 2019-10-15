package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = in.nextLine();
		System.out.print("Email: ");
		String email = in.next();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(in.next());
		Client client = new Client(name, email, birthDate);
		
		Date moment = new Date();
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = in.next();
		Order order = new Order(client, moment, OrderStatus.valueOf(status));
		
		System.out.print("How many items to this order? ");
		int n = in.nextInt();	
		for(int i = 1 ; i <= n ; i++) {
			System.out.println("Enter item #" + i + " data:");
			System.out.print("Product name: ");
			in.nextLine();
			String productName = in.nextLine();
			System.out.print("Product price: ");
			double productPrice = in.nextDouble();
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int quantity = in.nextInt();
			OrderItem item = new OrderItem(product, quantity, product.getPrice());			
			
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println(order);
		
		in.close();
	}

}
