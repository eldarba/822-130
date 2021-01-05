package a;

public class Test {

	public static void main(String[] args) {

//		Printer p = new MyAdvancedPrinter();
		Printer p = new MyPrinter();

		p.print("Hello");
		p.print("Hello", 3);

		if (p instanceof MyAdvancedPrinter) {
			MyAdvancedPrinter ap = (MyAdvancedPrinter) p;
			ap.AdvancedPrint("wow");
		}

	}

}
