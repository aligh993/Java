// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.util.Scanner;

public class q1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); 
		int a = sc.nextInt();
		int b = 0;
		for (int i=0; i<a; i++) { 
			int c = sc.nextInt();
			b = b + c;
			for (int j=0; j<b; j++) { 
				System.out.print("*");  
			};
			System.out.println("");
		}
		sc.close();
	}
}