package c;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class DemoTrees {

	public static void main(String[] args) {

		{ // numbers are sorted by numerical value
			Set<Integer> set = new TreeSet<Integer>();
			set.add(5);
			set.add(3);
			set.add(1);
			set.add(10);
			set.add(2);
			System.out.println(set);
		}

		{// numbers are sorted alphabetically
			Set<String> set = new TreeSet<>();
			set.add("hello");
			set.add("dan");
			set.add("aaa");
			set.add("music");
			set.add("java");
			System.out.println(set);
		}

		{// dates are sorted by time
			Set<LocalDate> set = new TreeSet<>();
			set.add(LocalDate.now());
			set.add(LocalDate.of(2025, 1, 1));
			set.add(LocalDate.of(2019, 1, 1));
			System.out.println(set);
		}

		{// others are sorted by its natural order
			Set<Person> set = new TreeSet<>();
			set.add(new Person(103, "ccc", 55));
			set.add(new Person(101, "aaa", 22));
			set.add(new Person(102, "bbb", 33));
			System.out.println(set);
		}

	}

}
