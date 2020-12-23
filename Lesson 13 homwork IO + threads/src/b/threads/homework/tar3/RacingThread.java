package b.threads.homework.tar3;

public class RacingThread extends Thread {

	private RacingThread rival;
	private static Object key = new Object(); // mutex (Mutually Exclusive Object)
	private static boolean win = true; // flag

	public RacingThread(String name, RacingThread rival) {
		super(name);
		this.rival = rival;
	}

	public RacingThread getRival() {
		return rival;
	}

	public void setRival(RacingThread rival) {
		this.rival = rival;
	}

	@Override
	public void run() {
		System.out.println(">>>>>" + getName() + " started");
		for (int i = 1; i <= 3; i++) {
			System.out.println(i + ": " + getName());
		}

		// finish line is a critical section
		synchronized (key) {
			if (win) {
				System.out.println(">>>>>" + getName() + " finished == won");
				win = false;
			} else {
				System.out.println(">>>>>" + getName() + " finished == lost");
			}
		}
	}

}
