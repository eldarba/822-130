package app.core.components;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	private List<Person> persons = new ArrayList<Person>();

	public void add(Person p) {
		persons.add(p);
	}

	public List<Person> getPersons() {
		return persons;
	}

}
