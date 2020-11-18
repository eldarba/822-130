package a;

public class Demo2SRandomNumber {

	public static void main(String[] args) {

		double r = Math.random();

		System.out.println(r);
		System.out.println(r * 11);
		System.out.println((int) (r * 11));
		System.out.println((int) (r * 11) + 5);

		System.out.println("================");
		// create random integer in the range 25 - 29 inclusive
		int a = -5, b = 5;
		int value = (int) (Math.random() * (b - a + 1)) + a;
		System.out.println(value);

	}

}
