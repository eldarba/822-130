package a.cars;

public class Shape {

	// static field
	private static int counter;

	// static initializer
	static {
		if (Math.random() < 0.5) {
			counter = 100;
		} else {
			counter = 200;
		}
	}

	// static methods
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Shape.counter = counter;
	}

}
