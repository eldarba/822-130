package a;

public class PersonTest {

	public static void main(String[] args) {

		Person p1 = new Person(111, "a", -1);
		System.out.println(p1.getId() + ", " + p1.getName() + ", " + p1.getAge());

		Student s1 = new Student();
		s1.setId(123);
		s1.setName("theStudent");
		s1.setAge(18);
		System.out.println(s1.getId() + ", " + s1.getName() + ", " + s1.getAge());
		s1.speak();

//		p1.printDetailes();
		s1.printDetailes();

	}

}
