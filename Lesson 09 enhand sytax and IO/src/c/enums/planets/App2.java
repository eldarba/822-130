package c.enums.planets;

import java.util.Arrays;

public class App2 {

	public static void main(String[] args) {

		System.out.println("enter planet: " + Arrays.toString(Planet.values()));

		Planet p = Planet.MARS;
		System.out.println(p);

	}

}
