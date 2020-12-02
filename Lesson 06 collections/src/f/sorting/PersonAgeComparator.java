package f.sorting;

import java.util.Comparator;

import c.Person;

public class PersonAgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {

		if (p1.getAge() < p2.getAge()) {
			return -1;
		}

		if (p1.getAge() == p2.getAge()) {
			return 0;
		}

		return 1;
	}

}
