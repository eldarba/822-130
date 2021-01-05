package b;

public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("thread started");

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			/*
//			 * if the thread is interrupted while in sleep an exception is thrown and the
//			 * interrupted status is cleared
//			 */
//			e.printStackTrace();
//		}

//		System.out.println("was I interrupted 1? " + Thread.interrupted()); // status cleared
//		System.out.println("was I interrupted 2? " + Thread.interrupted());

		System.out.println("was I interrupted 1? " + this.isInterrupted()); // status not cleared
		System.out.println("was I interrupted 2? " + this.isInterrupted());

		System.out.println("thread stopped");
	}

}
