package c.creatingThreads2;

// Runnable encapsulates the threads algorithm
public class MyRunnable implements Runnable {

	@Override
	public void run() {

		// in order to get access to Thread class methods we need a Thread reference
		Thread curr = Thread.currentThread();

		for (int i = 0; i < 100; i++) {
			System.out.println("hello from thread: " + curr.getName() + ": " + i);
		}
	}

}
