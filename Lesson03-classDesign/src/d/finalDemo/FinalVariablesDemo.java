package d.finalDemo;

public class FinalVariablesDemo {

	public static void main(String[] args) {

		int x = 5;
		x = 6;
		x = 7;

		// final variable
		final int y = 5;
//		y = 6; // cannot be reassigned after initialization

		// blank final variable
		final int z;
		System.out.println("z is not initialized yet");
		z = 10; // once blank final is initialized it cannot be changed
//		z = 5;

	}

}
