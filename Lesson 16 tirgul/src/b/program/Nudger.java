package b.program;

public class Nudger extends Thread {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				break;
			}
			System.out.println("קורה מה");
		}
	}

}
