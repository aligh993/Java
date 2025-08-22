// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

package compute;

public class reverse {

	public int reverseNum(int inp) {
		int reversed = 0;
		while(inp != 0) {
			int digit = inp % 10;
			reversed = reversed * 10 + digit;
			inp /= 10;
		}
		return reversed;
	}
}