package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] mat = new int[m][n];
		
		for(int i = 0 ; i < mat.length ; i++) {
			for(int j = 0 ; j < mat[i].length ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		int number = in.nextInt();
		
		for(int i = 0 ; i < mat.length ; i++) {
			for(int j = 0 ; j < mat[i].length ; j++) {
				if(mat[i][j] == number) {
					System.out.println("Position " + i + ", " + j);
					if(j > 0)
						System.out.println("Left: " + mat[i][j-1]);
					if(i > 0)
						System.out.println("Up: " + mat[i-1][j]);
					if(j < n)
						System.out.println("Right: " + mat[i][j+1]);
					if(i < m)
						System.out.println("Down: " + mat[i+1][j]);
					
				}
			}
		}
		
		in.close();
	}

}
