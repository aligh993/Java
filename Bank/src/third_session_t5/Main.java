// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

package third_session_t5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please Insert Your Type of Account "
				+ "('s' for Savings Account & 'c' for Current Account): ");
		Scanner sc = new Scanner(System.in);
		String accountType = sc.next();

		if (accountType.equalsIgnoreCase("s")){
			Savings_Account sa = new Savings_Account();
			System.out.println("Please Insert Your Name: ");
			sa.Name = sc.next();
			System.out.println("Please Insert Your AccountNumber: ");
			sa.AccountNumber = sc.nextInt();
			System.out.println("Please Insert Your Value: ");
			sa.Value = sc.nextInt();

			System.out.println("Please Insert Your Banking Operations"
					+ "('d' for Deposit & 'w' for Withdraw): ");
			String BO = sc.next();
			if (BO.equalsIgnoreCase("d")) {
				System.out.println("Please Insert Your Amount of Deposit: ");
				int v = sc.nextInt();
				sa.Deposit(v);
			} else if (BO.equalsIgnoreCase("w")) {
				System.out.println("Please Insert Your Amount of Withdraw: ");
				int v = sc.nextInt();
				sa.Withdraw(v);
			} else {
				System.out.println("Your Banking Operations Was not Found!");
			}
			sa.Compute_Account_Balance();
		}
		else if (accountType.equalsIgnoreCase("c")) {
			Current_Account ca = new Current_Account();
			System.out.println("Please Insert Your Name: ");
			ca.Name = sc.next();
			System.out.println("Please Insert Your AccountNumber: ");
			ca.AccountNumber = sc.nextInt();
			System.out.println("Please Insert Your Value: ");
			ca.Value = sc.nextInt();

			System.out.println("Please Insert Your Banking Operations"
					+ "('d' for Deposit & 'w' for Withdraw): ");
			String BO = sc.next();
			if (BO.equalsIgnoreCase("d")) {
				System.out.println("Please Insert Your Amount of Deposit: ");
				int v = sc.nextInt();
				ca.Deposit(v);
			} else if (BO.equalsIgnoreCase("w")) {
				System.out.println("Please Insert Your Amount of Withdraw: ");
				int v = sc.nextInt();
				ca.Withdraw(v);
			} else {
				System.out.println("Your Banking Operations Was not Found!");
			}
			ca.Compute_Account_Balance();
		}
		else {
			System.out.println("Your Account Was not Found!");
		}
		sc.close();
	}
}
