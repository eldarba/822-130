package f.io.defaults;

import java.io.IOException;

public class Demo1 {

	public static void main(String[] args) {

		System.out.println("starndard");
		System.err.println("err");

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("END");

	}

}
