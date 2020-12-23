package b.threads.homework.tar3;

public class Program {

	public static void main(String[] args) {

		RacingThread r1 = new RacingThread("r1", null);
		RacingThread r2 = new RacingThread("r2", r1);
		r1.setRival(r2);

		r1.start();
		r2.start();

	}

}
