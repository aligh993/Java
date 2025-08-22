// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.awt.List;

interface Queue {
	public List add(String input);
	public List delete(String input);
}

public class Fourth_Session_T1 implements Queue {

	@Override
	public List add(String input) {
		List list = new List();
		list.add(input);
		return list;
	}

	@Override
	public List delete(String input) {
		List list = new List();
		list.remove(input);
		return list;
	}

	public static void main(String[] args) {
		Fourth_Session_T1 n = new Fourth_Session_T1();
		n.add("Ali");
		n.add("Reza");
	}
}