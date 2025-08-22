// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.util.Scanner;

public class quera2 {

	public static void main(String[] args) {
		Scanner dd = new Scanner(System.in);
		int[] vars = new int[4];
		int out = 0;

		for(int i = 0; i < vars.length; i++) {
			vars[i] = dd.nextInt();
		}
		dd.close();
		if (vars[0] == vars[1] && vars[3] == vars[0] || vars[2] == vars[0]) {
			out = 1;
		} else {
			out = Math.min(vars[0], vars[1]);
		}
		System.out.println(out);
	}
}
