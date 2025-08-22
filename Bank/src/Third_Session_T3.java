// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.util.Scanner;

public class Third_Session_T3 {
	int PersonalNumber, Salary, Overtime, Tax, TotalSalary;
	String Name, Department, Insurance;

	Third_Session_T3(){
		PersonalNumber = 12;
		Name =  "Ali";
		Department = "Cyber Security";
		Salary = 2000000;
		Overtime = 5;
		Tax = 30;
		Insurance = "Melli";
	}

	Third_Session_T3(int PN, String N, String Dep, int sal, int OT, int T, String Ins){
		PersonalNumber = PN;
		Name = N;
		Department = Dep;
		Salary = sal;
		Overtime = OT;
		Tax = T;
		Insurance = Ins;	
	}

	public void userInput(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Insert Personal Number: ");
		PersonalNumber = sc.nextInt();
		System.out.println("Please Insert Name: ");
		Name = sc.next();
		System.out.println("Please Insert Department: ");
		Department = sc.next();
		System.out.println("Please Insert Salary: ");
		Salary = sc.nextInt();
		System.out.println("Please Insert Overtime: ");
		Overtime = sc.nextInt();
		System.out.println("Please Insert Tax: ");
		Tax = sc.nextInt();
		System.out.println("Please Insert Insurance: ");
		Insurance = sc.next();
		sc.close();
	}

	public int computeSalary() {
		TotalSalary = Salary - ((Tax*Salary)/100);
		return TotalSalary;
	}

	public void printOutput() {
		System.out.println("Your Personal Number: "+PersonalNumber);
		System.out.println("Your Name: "+Name);
		System.out.println("Your Department: "+Department);
		System.out.println("Your Salary: "+Salary);
		System.out.println("Your Overtime: "+Overtime);
		System.out.println("Your Tax: "+Tax);
		System.out.println("Your Insurance: "+Insurance);
		System.out.println("Your Total Salary: "+TotalSalary);
	}

	public static void main(String[] args) {
		Third_Session_T3 t3 = new Third_Session_T3();
//		Third_Session_T3 t3 = new Third_Session_T3(16, "Ali", "Cyber Security", 3000000, 3, 20, "Mellat");
		t3.userInput();
		t3.computeSalary();
		t3.printOutput();
	}
}
