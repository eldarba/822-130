package f.sorting;

import java.util.ArrayList;
import java.util.List;

import c.Person;

public class Demo1 {

	public static void main(String[] args) {

		{// others are sorted by its natural order
			List<Person> list = new ArrayList<>();
			list.add(new Person(103, "aaa", 55));
			list.add(new Person(101, "ccc", 22));
			list.add(new Person(102, "bbb", 33));

			// insert order
			System.out.println(list);

			// natural order - id
			list.sort(null);
			System.out.println(list);

			// other order - name
			PersonNameComparator nameComparator = new PersonNameComparator();
			list.sort(nameComparator);
			System.out.println(list);
		}

	}

}
