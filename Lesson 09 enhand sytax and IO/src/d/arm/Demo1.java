package d.arm;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {

		// ARM - try with resources

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("work with the scanner");
		}

		System.out.println("scanner closed");
	}

}
