package b.input;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("enter value: ");
		int x = sc.nextInt();
		System.out.println(x);

		System.out.print("enter  name: ");
		String name = sc.nextLine();
		System.out.println(name);

		sc.close();
	}

}
