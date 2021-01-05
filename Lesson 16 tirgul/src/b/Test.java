package b;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		MyThread t1 = new MyThread();
		t1.start();

		t1.interrupt();

	}

}
