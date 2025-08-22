// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

package third_session_t5;

public final class Current_Account extends Account {

	Current_Account(){
		Type = "Current Account";
	}

	public void Deposit(int input) {
		Value += input;
	}

	public void Deposit(short input) {
		Value += input;
	}

	public void Withdraw(int input) {
		Value -= input;
	}

	public void Withdraw(short input) {
		Value -= input;
	}

	public void Compute_Account_Balance() {
		System.out.println("Account Type: "+Type);
		System.out.println("Account Number: "+AccountNumber);
		System.out.println("Name: "+Name);
		System.out.println("Account Balance: "+Value);
	}
}