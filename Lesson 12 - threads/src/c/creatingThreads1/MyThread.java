package c.creatingThreads1;

public class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
	}

	// what this thread should do
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("hello from thread: " + this.getName() + ": " + i);
		}
	}

}
