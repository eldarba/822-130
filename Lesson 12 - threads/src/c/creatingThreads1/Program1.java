package c.creatingThreads1;

public class Program1 {

	public static void main(String[] args) {

		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");

		// starts this thread execution in a new stack
		t1.start();
		t2.start();

	}

}
