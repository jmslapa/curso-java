package map_exercice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enther the path of input file: ");
		String path = sc.nextLine();
		
		File file = new File(path);
		
		Map<String, Integer> electionReport = new LinkedHashMap<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String line = br.readLine();
			
			while(line != null) {
				 String[] fields = line.split(",");
				 if(electionReport.containsKey(fields[0])) {
					 Integer votesSummary = Integer.valueOf(electionReport.get(fields[0]) + Integer.valueOf(fields[1]));
					 electionReport.put(fields[0], votesSummary);
				 }else {
					 electionReport.put(fields[0], Integer.valueOf(fields[1]));
				 }
				 
				 line = br.readLine();
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		for(String key : electionReport.keySet()) {
			System.out.println(key + ": " + electionReport.get(key));
		}
		
		sc.close();
	}

}
