// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

package third_session_t5;

public abstract class Account {

	String Name, Type;
	int AccountNumber, Value;

	Account(){
		AccountNumber = 0;
		Name = "---";
		Value = 0;
	}

	public void Compute_Account_Balance() {
		System.out.println("Initial Account Number: "+AccountNumber);
		System.out.println("Initial Name: "+Name);
		System.out.println("Initial Account Balance: "+Value);
	}
}