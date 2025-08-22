// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import compute.*;

public class Fourth_Session{

	public static void main(String[] args) {
		t2();
	}
	
	public static void t2() {
		subtraction s = new subtraction();
		System.out.println("Subtraction num 20 & 5: "+s.SubtractionNum(20, 5));
		multiply m = new multiply();
		System.out.println("Multiply num 2 & 3: "+m.multiplyNum(2, 3));
		divide d = new divide();
		System.out.println("Divide num 10 & 2: "+d.DivideNum(10, 2));
		fact f = new fact();
		System.out.println("Factorial num 5: "+f.Factorial(5));
		reverse r = new reverse();
		System.out.println("reverse num 1596: "+r.reverseNum(1596));
	}
	
	public static void t3() {
		int a[] = {12, 564, 65};
		System.out.println(a[5]);
	}
}