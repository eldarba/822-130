package f.classNesting;

public class Outer {

	private int x;
	private static int y;

	class Inner {
		int a = x;
	}

	// instances of this class are not dependent on Outer
	static class Nested {
		int a = y;

	}

	public static void main(String[] args) {

		Nested n = new Nested();

		Outer o = new Outer();
		Inner i = o.new Inner();

	}

}
