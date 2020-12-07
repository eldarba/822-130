package c.loops;

import java.util.HashSet;
import java.util.Set;

public class Demo1 {

	public static void main(String[] args) {

		int[] arr = { 2, 4, 6, 8 };

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		System.out.println("============");
		for (int x : arr) {
			System.out.println(x);
		}

		// set
		Set<Integer> set = new HashSet<Integer>();
		set.add(2);
		set.add(4);
		set.add(6);

		System.out.println("============");
		for (int x : set) {
			System.out.println(x);
		}

	}

}
