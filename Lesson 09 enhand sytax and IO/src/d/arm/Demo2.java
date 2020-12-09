package d.arm;

import java.io.Closeable;
import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {

		// ARM - try with resources

		try (

				Scanner sc = new Scanner(System.in);

				MyClosable my = new MyClosable()

		) {
			System.out.println("work with the scanner");
		}

		System.out.println("scanner closed");
	}

}

class MyClosable implements Closeable {

	@Override
	public void close() {
		System.out.println("closed");
	}

}