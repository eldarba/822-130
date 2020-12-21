package b.threads;

public class ThreadDemo1 {

	public static void main(String[] args) {
		System.out.println("Hello");
		int x = 5;
		System.out.println(x);

		// creating a thread object
		Thread t = new Thread();
		// start thread execution
		t.start(); // what to do?

	}

}
