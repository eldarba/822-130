package c.loops;

public class Demo3 {

	public int add2(int a, int b) {
		return a + b;
	}

	public int add3(int a, int b, int c) {
		return a + b + c;
	}

	// this method will get 0 to infinity arguments
	public static int addN(int... values) {
		int sum = 0;
		for (int currentValue : values) {
			sum += currentValue;
		}
		return sum;
	}

	// the varargs parameter must be one and last
	public static int addN(String name, int... values) {
		System.out.println("hello " + name);
		int sum = 0;
		for (int currentValue : values) {
			sum += currentValue;
		}
		return sum;
	}

	public static void main(String... args) {
		System.out.println(addN(5));
		System.out.println(addN("aaa", 5, 3, 7, 1));
		System.out.println(addN(5, 7));
		System.out.println(addN());
	}
}
