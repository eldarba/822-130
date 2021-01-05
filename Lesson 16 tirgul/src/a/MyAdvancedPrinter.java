package a;

public class MyAdvancedPrinter implements Printer {

	@Override
	public void print(String text) {
		System.out.println(text);
	}

	@Override
	public void print(String text, int times) {
		for (int i = 0; i < times; i++) {
			System.out.println(text);
		}
	}

	public void AdvancedPrint(String text) {
		System.out.println("advanced: " + text);
	}

}
