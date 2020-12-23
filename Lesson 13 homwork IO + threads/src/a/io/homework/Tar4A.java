package a.io.homework;

import java.util.Scanner;

public class Tar4A {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);) {
			System.out.println("enter a line of text");

			String line = sc.nextLine();
			System.out.println(line);
		}

	}

}
