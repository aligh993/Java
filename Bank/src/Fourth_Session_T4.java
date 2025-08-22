// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

public class Fourth_Session_T4 {

	public static void main(String arg[]) {

		thread1 tc1 = new thread1();
		thread2 tc2 = new thread2();

		Thread t1 = new Thread(tc1);
		Thread t2 = new Thread(tc2);

		t1.start();
		t2.start();
	}
}

class thread1 implements Runnable{
	@Override
	public void run(){
		for (int i=0; i<40; i++) {
			if(i%2 == 0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
}

class thread2 implements Runnable {
	@Override
	public void run() {
		String a[] = {"a", "b", "c", "d", "e"};
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}