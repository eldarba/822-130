package d.wrrapers;

import java.util.ArrayList;
import java.util.List;

public class WrapperClasses {

	public static void main(String[] args) {

		// wrapper classes represent primitives as objects:
		byte n1 = 5;
		int n2 = 10;
		long n3 = 1000;

		Byte x1 = n1;
		Integer x2 = n2;
		Long x3 = n3;

		System.out.println(x1);
		System.out.println(x2);
		System.out.println(x3);

		// ==========================================
		System.out.println("===========================");
		// parse methods - used to convert text to numbers
		String str = "125";
		int num = Integer.parseInt(str);
		System.out.println(num++);
		System.out.println(num);

		// ========================================
		// min / max values
		System.out.println("===========================");
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);

		// ========================================
		System.out.println("===========================");
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(5);
		System.out.println(list);

		// Immutable - unchanged
		String s1 = "aaa";
		s1 = "bbb";

		Integer z1 = 5;
		z1 = 100;

		// mutable - can be changed
		Person p = new Person();
		p.setName("aaa");
		p.setName("bbb");
		p.setName("ccc");

	}

	// Generic and method signature
	public static void print1(List<Person> list) {
		System.out.println("aaaaa");
	}

	// you cannot overload
	public static void print2(List<Integer> list) {
		System.out.println("aaaaa");
	}

}

class Person {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
