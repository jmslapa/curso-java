package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import entities.ProductSummary;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter sold.csv file's path");
		String path = in.nextLine();
		File sold = new File(path);
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			if(line != null) {
				new File(sold.getParent() + "/out").mkdir();
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(sold.getParent() + "/out/summary.csv"))){
					while(line != null) {
						String[] array = new String[3];
						array = line.split(",");
						ProductSummary productSummary = new ProductSummary(array[0], Double.parseDouble(array[1]), Integer.parseInt(array[2]));
						bw.write(productSummary.toString() + "\n");
						line = br.readLine();
					}
				}
			}		
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Summary file sucessfully created");
		
		in.close();
	}
}
