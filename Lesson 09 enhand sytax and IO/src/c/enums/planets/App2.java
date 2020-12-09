package c.enums.planets;

import java.util.Arrays;
import java.util.Scanner;

public class App2 {

	public static void main(String[] args) {

		System.out.println("enter planet: " + Arrays.toString(Planet.values()));
		Scanner sc = new Scanner(System.in);

		try {

			Planet p = Planet.valueOf(sc.nextLine().toUpperCase());
			System.out.println(p);
			System.out.println("mass: " + p.getMass());
			System.out.println("orbit: " + p.getOrbit());
		} catch (IllegalArgumentException e) {
			System.out.println("input error: " + e.getMessage());
		}

		sc.close();
		System.out.println("Bye");

	}

}
