package a.interfaces;

import java.util.LinkedHashSet;
import java.util.Set;

public class Demo2 {

	public static void main(String[] args) {

		// create a List
		Set<String> set = new LinkedHashSet<String>();
		// add elements
		set.add("English");
		set.add("English");
		set.add("Math");
		set.add("Java");
		set.add("Math");
		set.add("Math");

		// print size and content
		System.out.println("size: " + set.size());
		System.out.println(set);

	}

}
