// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.util.Scanner;

public class quera1 {
	public static void main(String[] args) {
		Scanner dd = new Scanner(System.in);
		int[] vars = new int[6];
		int[] vars2 = new int[6];
		int out = 0;

		for(int i = 0; i < vars.length; i++) {
			vars[i] = dd.nextInt();
			if (i!= 0  && (i-1) % 2 == 0) {
				vars2[i] = Math.min(vars[i], vars[i-1]);
			}
		}
		dd.close();
		for (int i = 0; i < vars2.length; i++) {
			out = out + vars2[i];
		}
		System.out.println(out);
	}
}