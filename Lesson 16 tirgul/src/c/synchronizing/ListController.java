package c.synchronizing;

import java.util.ArrayList;
import java.util.List;

public class ListController {

	private List<Integer> list = new ArrayList<Integer>();

	{
		list.add(2);
		list.add(4);
		list.add(6);
	}

	// unsynchronized method - non critical - can be ran any time
	public void printList() {
		System.out.println(list);
	}

	// synchronized method - critical - blocks all critical sections to other
	// threads
	public synchronized Integer getLastElement() {
		System.out.println("getting last element");
		int size = list.size();
		int index = size - 1;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return list.get(index);
	}

	// synchronized method - critical - blocks all critical sections to other
	// threads
	public synchronized void deleteLastElement() {
		System.out.println("delete last element");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list.remove(list.size() - 1);
		System.out.println("last element removed");
	}

}
