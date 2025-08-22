// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.util.Scanner;

public class Second_Session_2 {

	public static void main(String[] args) {
		System.out.println("Please insert your number: ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt(); 
//		String input = sc.next(); // t3_4() & t4_2() function
		sc.close();
		t3_1(input);
	}

	public static void t3_1(int input) {
		System.out.println((int) Math.pow(input, 3));
	}

	public static void t3_2(int input) {
		int fact = 1;
		for(int i=1; i<=input; i++) {
			fact = fact*i;
		}
		System.out.println("Factorial "+input+" is: "+fact);
	}

	public static void t3_3(int input) {
		int reversed = 0;
		while(input != 0) {
			int digit = input % 10;
			reversed = reversed * 10 + digit;
			input /= 10;
		}
		System.out.println("Reversed number is: "+reversed);
	}

	public static void t3_4(String input) {
		boolean isPalindrome = true;
		int n = input.length();
		for(int i=0; i<n/2; i++) {
			if (input.charAt(i) != input.charAt(n-i-1)) {
				isPalindrome = false;
			}
		}
		System.out.println("is Palindrome: "+isPalindrome);
	}

	public static void t3_5(int input) {
		if(input%2 == 0) {
			System.out.println("Your Number is Even");
		} else {
			System.out.println("Your Number is Odd");
		}
	}

	public static void t3_6(int input) {
		int preNumber = 1;
		int nextNumber = 1;
		System.out.println("Fibonacci Series of "+input+" numbers is:");
		for(int i = 2; i <= input; i++) {
			System.out.print(preNumber+" ");
			int sum = preNumber + nextNumber;
			preNumber = nextNumber;
			nextNumber = sum;
		}
	}

	public static void t3_7(int input) {
		boolean prime = true;
		int p = input/2;
		if(input == 1) {
			prime = false;
		}
		for(int i=2; i<=p; i++) {
			if(input%i==0) {
				prime = false;
			}
		}
		System.out.println("is Prime: "+prime);
	}

	public static void t3_8(int input1, int input2) {
		System.out.println("a_in: "+input1+", "+"b_in: "+input2);
		int temp = input2;
		input2 = input1;
		input1 = temp;
		System.out.println("a_out: "+input1+", "+"b_out: "+input2);
	}

	public static void t4_1(int input) {
		System.out.println((int) Math.pow(input, 3));
	}

	public static void t4_1(float input) {
		System.out.println((float) Math.pow(input, 3));
	}

	public static void t4_2(int input) {
		System.out.println(input);
	}

	public static void t4_2(String input) {
		System.out.println(input);
	}
}
