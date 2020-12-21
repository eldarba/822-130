package h.waitNotify;

public class Producer extends Thread {

	private Stack stack;
	private int amount;
	private long sleepTime;

	public Producer(String name, Stack stack, int amount, long sleepTime) {
		super(name);
		this.stack = stack;
		this.amount = amount;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		for (int i = 0; i < amount; i++) {
			int val = (int) (Math.random() * 10);
			stack.push(val);
			System.out.println(getName() + " pushed: " + val);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
