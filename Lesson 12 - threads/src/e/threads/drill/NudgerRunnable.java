package e.threads.drill;

public class NudgerRunnable implements Runnable {

	// to make waiting time configurable use variables
	private long wait1;
	private long wait2;

	public NudgerRunnable(long wait1, long wait2) {
		super();
		this.wait1 = wait1 * 1000;
		this.wait2 = wait2 * 1000;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(wait1);
			System.out.println("The system is waiting for input");
			while (true) {
				Thread.sleep(wait2);
				System.out.println("The system is still waiting");
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
