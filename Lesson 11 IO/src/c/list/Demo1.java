package c.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo1 {

	public static void main(String[] args) {

		// create lists
		List<Integer> arrayList = new ArrayList<Integer>(); // good for random access
		List<Integer> linkedList = new LinkedList<Integer>(); // good for inserts / deletes

		// populate lists
		for (int i = 0; i < 10_000_000; i++) {
			int r = (int) (Math.random() * 101);
			arrayList.add(r);
			linkedList.add(r);
		}

		// set variables for timing
		long ts1, ts2;

		// test the array list
		ts1 = System.currentTimeMillis();
		arrayList.add(5, 30);
		ts2 = System.currentTimeMillis();
		System.out.println(ts2 - ts1 + " ms");

		System.out.println("=================");

		// test the linked list
		ts1 = System.currentTimeMillis();
		linkedList.add(5, 30);
		ts2 = System.currentTimeMillis();
		System.out.println(ts2 - ts1 + " ms");

	}

}
