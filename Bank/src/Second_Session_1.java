// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.util.Scanner;

public class Second_Session_1 {

	public static void main(String[] args) {
		t1_1();
	}

	public static void t1_1() {
		int a[] = {32,14,70,40,26,68};
		int max = a[0];
		for (int i=0; i<a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		System.out.print("Maximum is: "+max);
	}

	public static void t1_2() {
		System.out.println("Please insert your number: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();

		int a[] = {32,14,70,40,26,68};
		int len = a.length;
		for (int i=0; i<len; i++) {
			if(a[i] == num) {
				System.out.print("Your number was found.");
				break;
			} else if (i == len-1) {
				System.out.print("Your number not exist in array.");
			}
		}
	}

	public static void t1_3() {
		int a[] = {32,14,70,40,26,68};
		int len = a.length;
		for (int i=0; i<len; i++) {
			for (int j=0; j<len-1; j++) {
				if (a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
		for (int i=0; i<len; i++) {
			System.out.print(a[i]+", ");
		}
	}

	public static void t1_4() {
		int a[] = {32,14,70,40,26,68};
		int len = a.length;
		int largest = a[0];
		int secondLargest = a[0];
		for (int i=0; i<len; i++) {
			if (a[i] > largest) {
				secondLargest = largest;
				largest = a[i];
			} else if (a[i] > secondLargest) {
				secondLargest = a[i];
			}
		}
		System.out.print("Second largest number is: " + secondLargest);
	}

	public static void t1_5() {
		int a[] = {32,14,70,40,26,68};
		int len = a.length;
		for (int i=0; i<len/2; i++) {
			int temp = a[i];
			a[i] = a[len-1-i];
			a[len-1-i] = temp;
		}
		for (int i=0; i<len; i++) {
			System.out.print(a[i]+", ");
		}
	}

	public static void t2_1() {
		int a[][] = {{1, 2}, {3, 4}};
		System.out.println("Input: ");
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		int b[][] = new int[2][2];
		System.out.println("\nOutput: ");
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				b[i][j] = a[i][j]+a[j][i];
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void t2_2() {
		int a[][] = {{1, 2}, {3, 4}};
		System.out.println("Input: ");
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		int b[][] = new int[2][2];
		System.out.println("\nOutput: ");
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				b[i][j] = a[j][i];
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void t2_3() {
		int a[][] = {{1, 2}, {3, 4}};
		System.out.println("Input: ");
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		int b = 0;
		System.out.println("\nOutput: ");
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				b = a[i][j]+b;
			}
		}
		System.out.print(b);
	}
}