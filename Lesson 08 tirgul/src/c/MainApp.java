package c;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		greet();
		int num = getNumberFromUser();
		System.out.println("the number was : " + num);
		System.out.println(Arrays.toString(getRandomNames(num)));
	}

	// A
	private static void greet() {
		System.out.println("Hello");
	}

	// B
	private static int getNumberFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter number: ");
		int x = Integer.parseInt(sc.nextLine());
		sc.close();
		return x;
	}

	// C
	private static String[] getRandomNames(int length) {
		String[] names = new String[length];
		for (int i = 0; i < names.length; i++) {
			names[i] = "name" + i;
		}
		return names;
	}

}
