package a.person;

public class Test1 {

	public static void main(String[] args) {

//		 static reference - use class name
		System.out.println("count: " + Person.getCounter());

		Person p1 = new Person("Dan");

		Person p2 = new Person("Dikla");

		// dynamic reference - use instance reference name
		System.out.println(p2.id);
		System.out.println(p2.name);

		System.out.println("count: " + Person.getCounter());
//		Person.counter = 10000;

	}
}
