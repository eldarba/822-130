package f.sorting;

import java.util.Comparator;

import c.Person;

public class PersonNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		return p1.getName().compareTo(p2.getName());
	}

}
