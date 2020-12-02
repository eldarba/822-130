package a.exceptions;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionDemo {

	public static void main(String[] args) {
		int x = 3;

		System.out.println("in main");
		try {
			System.out.println(9 / 3);
			// this is what we are trying to do
			m1();
		} catch (IOException e) {
			// this is handler - runs in case of exception
			System.out.println("io exception");
			e.printStackTrace();
			return;
		} catch (Exception e) {
			// this is handler - runs in case of exception
			System.out.println("some other exception");
			e.printStackTrace();
			return;
		} finally {
			// this block runs anyway
			System.out.println("from finally block");
		}

		System.out.println("SUCCESS");

	}

	public static void m1() throws IOException, ArithmeticException {
		int x = 5;
		if (x == 0) {
			throw new RuntimeException("x was 0");
		}
		String name = "David";
		System.out.println("in m1");
		System.out.println(9 / x); // this line might throw ArithmeticException
		m2();
	}

	public static void m2() throws IOException {
		System.out.println("in m2");
//		FS is an external mechanism we can work with

		/*
		 * File represents a location of a file or directory
		 */
		File file = new File("c:/temp/eldar/letter.txt");
		System.out.println(file);
		file.createNewFile();

	}

}
