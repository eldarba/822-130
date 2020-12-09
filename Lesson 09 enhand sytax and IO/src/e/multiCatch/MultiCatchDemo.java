package e.multiCatch;

import java.util.Scanner;

public class MultiCatchDemo {

	public static void main(String[] args) {

		String[] arr = { "2", "4", "A", "6" };

		try (Scanner sc = new Scanner(System.in);) {
			System.out.println("enter index: [0, 1, 3]");
			int index = Integer.parseInt(sc.nextLine());
			int x = Integer.parseInt(arr[index]);
			System.out.println("in idex 1 you have: " + x);
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("error: " + e);
		}

		System.out.println("============");
	}

}
