package b.threads;

public class ThreadDemo2Mmain {

	public static void main(String[] args) {

		// get a reference to the currently running thread - main thread
		Thread main = Thread.currentThread();

		System.out.println("thread's name is: " + main.getName());

	}

}
