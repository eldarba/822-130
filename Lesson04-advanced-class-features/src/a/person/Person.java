package a.person;

public class Person {

	// class variables
	private static int counter;

	// attributes - instance variables
	int id;
	String name;

	// CTOR
	public Person(int id, String name) {
		super();

		// this - reference to current Person instance

		this.id = id;
		this.name = name;

		// Person - class name is reference to the class object
		Person.counter++;
	}

	// static method - class method - invoked by the class
	public static int getCounter() {
		return counter;
	}

	// dynamic methods - instance method - invoked by the class instances
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
