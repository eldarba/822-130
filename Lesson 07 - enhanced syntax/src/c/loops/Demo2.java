package c.loops;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {

	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();
		names.add("aaa");
		names.add("bbb");
		names.add("ccc");

		System.out.println(names);

		// when using for loop we have an index which gives us direct access to the
		// element in the collection
		for (int i = 0; i < names.size(); i++) {
			if (i == 1) {
				names.set(i, "BBB");
			}
		}

		// you cannot assign new value to the current element in the collection when
		// using for-each loop
		for (String name : names) {
			if (name.equals("bbb")) {
				name = "BBB"; // this assignment is local and will not change the collection
			}
		}

		System.out.println(names);
	}

}
