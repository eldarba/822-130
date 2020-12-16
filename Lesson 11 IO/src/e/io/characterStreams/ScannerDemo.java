package e.io.characterStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {

		String source = "aaa bbb ccc end";
		try (Scanner sc = new Scanner(source);) {

			while (sc.hasNext()) {
				System.out.println(sc.next());
			}
		}

		source = "aaa|bbb|ccc|end";
		try (Scanner sc = new Scanner(source);) {
			sc.useDelimiter("[|]");

			while (sc.hasNext()) {
				System.out.println(sc.next());
			}
		}

		System.out.println("===================");

		// do the same thing with a file
		try (Scanner sc = new Scanner(new File("files/file"));) {

			while (sc.hasNext()) {
				System.out.println(sc.next());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
