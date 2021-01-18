package b.recursion;

public class Demo2Factorial {

	public static void main(String[] args) {

//		System.out.println("0! = " + factorial(0));
//		System.out.println("1! = " + factorial(1));
//		System.out.println("2! = " + factorial(2));
//		System.out.println("3! = " + factorial(3));
//		int x = factorial(4);
//		System.out.println("4! = " + x);
		System.out.println("5! = " + factorial(5));
		System.out.println("6! = " + factorial(6));
		System.out.println("16! = " + factorial(16));
		System.out.println("17! = " + factorial(17));

	}

	// O(n)
	public static int factorial(int n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

}
