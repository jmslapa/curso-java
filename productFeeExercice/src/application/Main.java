package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.UsedProduct;
import entities.ImportedProduct;
import entities.Product;

public class Main{
	
	public static void main(String[] args) throws ParseException {
		
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner in = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = in.nextInt();
		for(int i = 1 ; i <= n ; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			in.nextLine();
			char answer = in.next().charAt(0);
			System.out.print("Name: ");
			in.nextLine();
			String name = in.nextLine();
			System.out.print("Price: ");
			double price = in.nextDouble();
			if(answer == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = in.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}else if(answer == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(in.next());
				list.add(new UsedProduct(name, price, manufactureDate));
			}else {
				list.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product obj : list) {
			System.out.println(obj.toString());
		}
		
		in.close();
	}
}
