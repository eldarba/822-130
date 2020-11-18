package app.persons;

public class Person {

	int id;
	String name;
	int age;

	public void speak() {
		System.out.println("I am speaking");
	}

	// method overload - same name different parameters
	public void speak(int times) {
		for (int i = 0; i < times; i++) {
			speak();
		}
	}

	public static void main(String[] args) {
		Person p = new Person();
		p.speak(5);
		p.speak();

		System.out.println(4);
		System.out.println("aaa" + "bbb" + "ccc" + 66 + new Person());
		System.out.println(7.36);
	}

}
