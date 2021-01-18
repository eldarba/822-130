package b.recursion;

public class Demo1 {

	public static void main(String[] args) {
		printOntToValR(5);
	}

	// endless - do not do this
	public static void m1() {
		System.out.println("hello");
		m1();
	}

	public static void printOntToVal(int val) {
		for (int i = 1; i <= val; i++) {
			System.out.println(i);
		}
	}

	public static void printOntToValR(int val) {
		if (val <= 1) {
			System.out.println(val);
			return;
		} else {
			printOntToValR(val - 1);
			System.out.println(val);
			return;
		}
	}

}
