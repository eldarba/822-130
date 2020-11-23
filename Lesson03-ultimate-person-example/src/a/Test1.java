package a;

public class Test1 {
	public static void main(String[] args) {

		Person p1 = new Person(101, "aaa", 22);
		Person p2 = p1;

		System.out.println(p1.equals(p2));

		p1 = null;
		p2 = null;

		System.gc();

		System.out.println("END");
	}
}
