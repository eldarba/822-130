package d.iterators;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Demo1 {

	public static void main(String[] args) {

		Set<Integer> set = new TreeSet<>();
		set.add(523);
		set.add(344);
		set.add(144);
		set.add(10);
		set.add(2);
		System.out.println(set);

		Iterator<Integer> it = set.iterator();

		while (it.hasNext()) {
			int curr = it.next();
			if (curr % 2 != 0) {
				it.remove();
			}
			System.out.println(curr);
		}
		System.out.println(set);
	}

}
