package a.io.exercise;

import java.io.IOException;

public class Tar1A {

	public static void main(String[] args) {

		try {
			// prompt user for input
			System.out.println("enter a line");
			int c = System.in.read(); // get first character
			while (c != 13) {
				System.out.write(c); // print current character
				c = System.in.read(); // get next character
			}
			// flush the buffer of the default output
			System.out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
