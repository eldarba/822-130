package b.recursion;

import java.math.BigInteger;

public class Demo2FactorialBigInteger {

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
		System.out.println("100! = " + factorial(100));

	}

	public static BigInteger factorial(int n) {
		if (n == 1 || n == 0) {
			return new BigInteger("1");
		} else {
//			return n * factorial(n - 1);
			return factorial(n - 1).multiply(new BigInteger(String.valueOf(n)));
		}
	}

}
