package a.interfaces;

import java.util.HashMap;
import java.util.Map;

public class Demo3 {

	public static void main(String[] args) {

		// create a List
		Map<Integer, String> map = new HashMap<>();
		// add elements
		map.put(3, "English");
		map.put(4, "אנגלית"); // overrides previous value
		map.put(5, "English");
		map.put(6, "Math");
		map.put(7, "Java");
		map.put(8, "Math");
		map.put(9, "Math");

		// print size and content
		System.out.println(map);

		System.out.println(map.get(4));

	}

}
