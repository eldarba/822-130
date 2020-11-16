package e.ctors;

public class Person {

	private int id;
	private String name;
	private int age;

	public Person() {
	}

	public Person(int id, String name, int age) {
		super();// invoke the CTOR of supr (Object class)
		Person.this.id = id;
		this.name = name;
		this.age = age;
	}

	public Person(int id) {
		this(id, "default_name", 18);// invoke a CTOR in this class
	}

	public static void main(String[] args) {
		System.out.println();
		Person p1 = new Person(111, "aaa", 22);

	}

}
