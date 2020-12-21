package d.stoppingThreads;

public class MyStopableThreadNoSleep extends Thread {

	public MyStopableThreadNoSleep(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 1500; i++) {
			System.out.println(getName() + ": " + i);
			if (isInterrupted()) {
				System.out.println(getName() + " was interrupted and is going to stop");
				// do some cleanup stuff - close resources etc.
				break;
			}
		}

		System.out.println(getName() + " is done");
	}

}
