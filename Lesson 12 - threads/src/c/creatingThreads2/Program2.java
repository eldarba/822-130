package c.creatingThreads2;

public class Program2 {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("main starts");

		MyRunnable r = new MyRunnable();
		Thread t1 = new Thread(r, "t1");
		System.out.println("state: " + t1.getState());

		t1.start();
		System.out.println("state: " + t1.getState());

		Thread.sleep(200); // make main sleep

//		t1.stop();  // Do not use stop() to stop a thread

		System.out.println("state: " + t1.getState());

		t1.join(); // send main thread to blocked pool until t1 is terminated

		System.out.println("state: " + t1.getState());

		System.out.println("main ends");

	}

}
