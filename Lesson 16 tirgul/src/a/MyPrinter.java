package a;

public class MyPrinter implements Printer {

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

}
