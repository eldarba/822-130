package a;

public class Person {

	// attributes / fields
	int id;
	private String name;
	private int age;

	// CTOR 1
	public Person() {
	}

	// CTOR 2
	public Person(int id, String name, int age) {
		setId(id);
		setName(name);
		setAge(age);
	}

	// methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 0) {
			this.id = id;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && name.length() > 0 && name.length() <= 10) {
			this.name = name;
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 0 && age <= 120) {
			this.age = age;
		}
	}

	public void speak() {
		System.out.println("person named " + name + " is now speaking");
	}

}
