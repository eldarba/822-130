package h.waitNotify;

public class Consumer extends Thread {

	private Stack stack;
	private int amount;
	private long sleepTime;

	public Consumer(String name, Stack stack, int amount, long sleepTime) {
		super(name);
		this.stack = stack;
		this.amount = amount;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		for (int i = 0; i < amount; i++) {
			Integer val = stack.pop();
			System.out.println(getName() + " popped: " + val);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
