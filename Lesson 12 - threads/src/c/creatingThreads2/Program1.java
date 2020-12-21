package c.creatingThreads2;

public class Program1 {

	public static void main(String[] args) throws InterruptedException {

		MyRunnable r = new MyRunnable();
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");

		t1.start();
//		Thread.sleep(500);
		t2.start();

	}

}
