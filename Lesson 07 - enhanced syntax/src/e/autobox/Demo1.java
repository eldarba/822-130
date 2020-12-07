package e.autobox;

public class Demo1 {

	public static void main(String[] args) {

		Integer x = new Integer(5); // inbox
		int a = x.intValue(); // outbox

		Integer y = 5; // auto inbox
		int b = y; // auto outbox

	}

}
