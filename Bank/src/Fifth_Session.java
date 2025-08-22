// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Fifth_Session {

	public static void main(String[] args) {
		t2_3();
	}

	public static void t2_1() {
		ArrayList<Integer> a = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			a.add(i);
		}
		System.out.println(a);
	}

	public static void t2_2() {
		String name[] = {"Ali", "Reza", "Mohammad", "Amir", "Mahbod"};
		int PersonalNumber[] = {1555, 5786, 1289, 4393, 1975};
		HashMap<String, Integer> hm = new HashMap<>();
		for(int i=0; i<name.length; i++) {
			hm.put(name[i], PersonalNumber[i]);
		}
		System.out.println(hm);
	}

	public static void t2_3() {
		String name[] = {"Ali", "Reza", "Mohammad", "Amir", "Mahbod"};
		int score[] = {17, 5, 13, 16, 8};
		int max_init = 0;
		Hashtable<Integer, String> hm = new Hashtable<>();
		for(int i=0; i<name.length; i++) {
			hm.put(score[i], name[i]);
			int max = score[i];
			if (max > max_init) {
				max_init = score[i];
			}
		}
		System.out.println(hm+"  The Highest Score is: "+hm.get(max_init));
	}
}
