package a.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

	public static void main(String[] args) {

		// create a List
		List<String> list = new ArrayList<>();
		// add elements
		list.add("English");
		list.add("English");
		list.add("Math");
		list.add("Java");
		list.add("Math");
		list.add("Math");

		// print size and content
		System.out.println("size: " + list.size());
		System.out.println(list);

	}

}
