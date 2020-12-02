package c;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Demo2Constructors {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(3);
		list.add(5);
		list.add(3);
		list.add(2);
		System.out.println(list);
//		List ls = list;
//		ls.add("aaa");
//		System.out.println(list);

		Set<Integer> set = new LinkedHashSet<>(list);
		System.out.println(set);

	}

}
