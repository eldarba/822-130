package f.io.defaults;

import java.io.IOException;

public class Demo3 {

	public static void main(String[] args) {

		System.out.println("enter line:");

		// byte stream

		try {
			int b = System.in.read(); // read the first byte
			while (b != 13) {
				System.out.print((char) b); // print current byte
				b = System.in.read(); // read the next byte
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
