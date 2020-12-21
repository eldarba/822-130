package d.stoppingThreads;

public class MyStopableThread extends Thread {

	public MyStopableThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println(getName() + ": " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(getName() + " was interrupted and is going to stop");
				// do some cleanup stuff - close resources etc.
				break;
			}
		}

		System.out.println(getName() + " is done");
	}

}
