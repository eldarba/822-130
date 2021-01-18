package b.recursion;

public class Demo3Fibonaci {

	public static void main(String[] args) {
		long ts1, ts2;
		int n = 41;

		ts1 = System.currentTimeMillis();
		System.out.println("fib[" + n + "] = " + fibR(n));
		ts2 = System.currentTimeMillis();

		System.out.println(ts2 - ts1 + " ms");
	}

	// Linear time: O(n)
	public static int fib(int n) {
		int f1 = 1, f2 = 1, temp;
		for (int i = 2; i < n; i++) {
			temp = f2;
			f2 = f1 + f2;
			f1 = temp;
		}
		return f2;
	}

	// exponential time: O(2^n)
	public static int fibR(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else {
			return fibR(n - 1) + fibR(n - 2);
		}
	}

}
