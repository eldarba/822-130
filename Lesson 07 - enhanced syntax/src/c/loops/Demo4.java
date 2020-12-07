package c.loops;

public class Demo4 {

	public static int add(int a, int b) {
		return a + b;
	}

	public static int add(int a, int b, int c) {
		return a + b + c;
	}

	// this method will get 0 to infinity arguments
	public static int add(int... values) {
		int sum = 0;
		for (int currentValue : values) {
			sum += currentValue;
		}
		return sum;
	}

	public static void main(String... args) {
		System.out.println(add(5));
		System.out.println(add(5, 3, 7, 1));
		System.out.println(add(5, 7));
		System.out.println(add(5, 7, 1));
		System.out.println(add());
	}
}
