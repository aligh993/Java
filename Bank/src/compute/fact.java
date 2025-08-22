// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

package compute;

public class fact {

	public int Factorial(int inp) {
		int fact = 1;
		for(int i=1; i<=inp; i++) {
			fact = fact*i;
		}
		return fact;
	}
}