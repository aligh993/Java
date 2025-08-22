// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.util.Scanner;

public class First_Session {

	public static void main(String[] args) {
		t2_6();
	}

	public static void t2_1() {
		int i = 0;
		System.out.println("Even number: ");
		while(i < 20) {
//			if(i % 2 == 0) {
//				System.out.print(i+",");
//			}
//			i++;
			System.out.print(i+",");
			i = i + 2;
		}
		i = 1;
		System.out.println("\nOdd number: ");
		while(i < 20) {
//			if(i % 2 != 0) {
//				System.out.print(i+",");
//			}
//			i++;
			System.out.print(i+",");
			i = i + 2;
		}
	}

	public static void t2_2() {
		System.out.println("Please insert your number: ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		
		long fact = 1;
		int i = 1;
		while(i <= number)
		{
			fact = fact * i;
			i++;
		}
		System.out.println("Factorial of "+number+" is: "+fact);
	}
	
	public static void t2_5() {
		System.out.println("Please insert your number: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		int reversed = 0;
        while(num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        System.out.println("Reversed Number: " + reversed);
	}

	public static void t2_6() {
		System.out.println("How many numbers you want in Fibonacci:");
		Scanner sc = new Scanner(System.in);
		int maxNumber = sc.nextInt();
		sc.close();
		System.out.println("Fibonacci Series of "+maxNumber+" numbers:");
		
		int preNumber = 1;
		int nextNumber = 1;
		int i = 2;
		while(i <= maxNumber) {
			System.out.print(preNumber+" ");
			int sum = preNumber + nextNumber;
			preNumber = nextNumber;
			nextNumber = sum;
			i++;
		}
	}
}