// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

package third_session_t5;

public final class Savings_Account extends Account {

	int interest;
	Savings_Account(){
		interest = 4;
		Type = "Savings Account";
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
		int TotalValue = Value + ((interest*Value)/100);
		System.out.println("Account Type: "+Type);
		System.out.println("Account Number: "+AccountNumber);
		System.out.println("Name: "+Name);
		System.out.println("Account Balance: "+TotalValue);
	}
}
