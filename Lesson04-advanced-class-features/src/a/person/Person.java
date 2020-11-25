package a.person;

public class Person {

	// class variables
	private static int counter;
	// constant - is a combination of final and static
	public static final int MAX_AGE = 120;

	// attributes - instance variables
	final int id;
	String name;

	// CTOR
	public Person() {

	}

	// static initializer
	// runs on class load - only once
	static {
		System.out.println("Person class loaded");
	}

	// dynamic initializer
	// block in the class level is an "initializer"
	{
		// initializer block runs before the ctor on each instance creation
		System.out.println("Person initializer");
		Person.counter++;
		this.id = counter;
	}

	// CTOR
	public Person(String name) {
		super();

		// this - reference to current Person instance

		this.name = name;

		// Person - class name is reference to the class object
	}

	// static method - class method - invoked by the class
	public static int getCounter() {
		return counter;
	}

	// dynamic methods - instance method - invoked by the class instances
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
