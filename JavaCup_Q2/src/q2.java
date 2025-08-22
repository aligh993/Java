// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.util.Scanner;

public class q2 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); 
		String str = sc.nextLine();
		boolean cap = false;
		boolean sh_dn = false;
		boolean sh_up = true;
		for (String retval: str.split(" ")) {
	         if (retval.equals("CAPSLOCK")) {
	        	 cap = true;
	        	 System.out.print(retval.replace("CAPSLOCK", "")); 
	         } else if (cap==true && Character.isLowerCase(retval.charAt(0))) {
	        	 System.out.print(retval.toUpperCase()+" ");
	         } else if (cap==true && Character.isUpperCase(retval.charAt(0))) {
	        	 System.out.print(retval.toLowerCase()+" ");
	         } else if (retval.equals("shift_down")) {
	        	 sh_dn = true;
	        	 sh_up = false;
	        	 System.out.print(retval.replace("shift_down", ""));
	         } else if (retval.equals("shift_up")) {
	        	 sh_dn = false;
	        	 sh_up = true;
	        	 System.out.print(retval.replace("shift_up", ""));
	         } else if (sh_dn == true && sh_up == false) {
	        	 retval = retval.replace("1", "!");
	        	 retval = retval.replace("2", "@");
	        	 retval = retval.replace("3", "#");
	        	 retval = retval.replace(",", "<");
	        	 retval = retval.replace(".", ">");
	        	 retval = retval.replace("/", "?");
	        	 retval = retval.toUpperCase();
	        	 System.out.print(retval + " ");
	         } else if (sh_dn == false && sh_up == true) {
	        	 retval = retval.replace("!", "1");
	        	 retval = retval.replace("@", "2");
	        	 retval = retval.replace("#", "3");
	        	 retval = retval.replace("<", ",");
	        	 retval = retval.replace(">", ".");
	        	 retval = retval.replace("?", "/");
	        	 retval = retval.toLowerCase();
	        	 System.out.print(retval + " ");
	         } else {
	        	 System.out.print(retval + " ");
	         }
	      } 
		sc.close();
	}
}