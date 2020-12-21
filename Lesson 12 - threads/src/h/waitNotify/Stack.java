package h.waitNotify;

import java.util.ArrayList;
import java.util.List;

public class Stack {

	private List<Integer> list = new ArrayList<Integer>();
	public static final int MAX = 10;

	// producer will use a push method to add numbers
	public synchronized void push(int val) {
		while (list.size() == MAX) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.add(val);
		notify();
	}

	public synchronized Integer pop() {
		while (list.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Integer val = list.remove(list.size() - 1);
		notify();
		return val;
	}

}
