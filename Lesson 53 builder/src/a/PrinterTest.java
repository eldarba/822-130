package a;

import static a.Printer.moveStatic;

import a.Printer.Builder;

public class PrinterTest {

	public static void main(String[] args) {

		Printer p1 = new Builder("plain", "color", "1500S")

				.setFaxEnabled(true)

				.setScannerEnabled(true)

				.build();

		System.out.println(p1);

		// with static import we can call the static method without specifying the class
		moveStatic();

	}

}
