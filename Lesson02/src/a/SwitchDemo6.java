package a;

import java.util.Scanner;

public class SwitchDemo6 {

	public static void main(String[] args) {

		// scanner is an input object
		Scanner sc = new Scanner(System.in);

		// prompt the user for input
		System.out.println("enter machine mode [ON, OFF, STAND_BY]");
		// get the user input
//		String mode = sc.nextLine(); // get entire line
		String mode = sc.next(); // get a single token
		mode = mode.toUpperCase(); // convert to upper case to prevent errors
//		System.out.println("you entered: " + mode);
		sc.close(); // close the scanner

		switch (mode) {
		case "ON":
			System.out.println("the machine is on");
			break;
		case "OFF":
			System.out.println("the machine is off");
			break;
		case "STAND_BY":
			System.out.println("the machine is in stand by mode");
			break;
		default:
			System.out.println(mode + " is an ivalid machine mode");
			break;
		}

	}

}
