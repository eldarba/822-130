package c.enums.machines;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Machine m1 = new Machine(1);
		Machine m2 = new Machine(2);

		System.out.println(m1);
		System.out.println(m2);

		m1.setMode(MachineMode.STAND_BY);
		m2.setMode(MachineMode.ON);

		System.out.println("=====================");
		System.out.println(m1);
		System.out.println(m2);

		System.out.println("=====================");
		System.out.println("any enum can do:");

		// get an array of all enum constants
		MachineMode[] modes = MachineMode.values();
		System.out.println(Arrays.toString(modes));

		System.out.print("enter machine mode " + Arrays.toString(modes));
		Scanner sc = new Scanner(System.in);

		// convert from String to enum
		MachineMode mode = MachineMode.valueOf(sc.nextLine());
		System.out.println(mode);

		sc.close();

	}

}
