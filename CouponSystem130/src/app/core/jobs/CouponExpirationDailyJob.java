package app.core.jobs;

import java.util.concurrent.TimeUnit;

public class CouponExpirationDailyJob implements Runnable {

	private Object dao;
	private boolean quit;
	private Thread t; // the thread that encapsulates this Runnable

	public CouponExpirationDailyJob(Object dao) {
		super();
		this.dao = dao;
	}

	public void setT(Thread t) {
		this.t = t;
	}

	@Override
	public void run() {
		while (!quit) {
			System.out.println("job - delete expired coupons - using DAOs");
			try {
				// Thread.sleep(TimeUnit.HOURS.toMillis(24)); // runtime
				Thread.sleep(TimeUnit.SECONDS.toMillis(10)); // for testing
			} catch (InterruptedException e) {
				// e.printStackTrace();
				System.out.println("job sleep was interrupted");
			}
		}

		System.out.println("daily job is ended");

	}

	public void stop() {
		this.quit = true;
		// Thread.currentThread().interrupt(); // wrong thread
		t.interrupt();
	}

}
