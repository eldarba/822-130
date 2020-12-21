package e.threads.drill;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Thread thread = new Thread(new NudgerRunnable(1, 5));
		thread.start();

		System.out.println("Hello. Please enter your name");
		try (Scanner sc = new Scanner(System.in);) {
			String name = sc.nextLine();
			System.out.println("Hello " + name);
			thread.interrupt(); // will stop nudge
			System.out.println("=== END ===");
		}

	}

}
