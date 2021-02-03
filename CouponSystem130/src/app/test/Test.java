package app.test;

import app.core.db.ConnectionPool;
import app.core.exceptions.CouponSystemException;
import app.core.facade.Facade;
import app.core.login.LoginManager;

public class Test {

	public static void main(String[] args) {

		Thread job = new Thread();

		try {
			// start the system =================
			ConnectionPool.getInstance(); // will start the connection pool
			// start the daily job thread
			job.start();
			// ==================================

			// ======the test======================================================

			// login - get a facade using the login Manager
			Facade facade = LoginManager.getInstance().login(); // you need to give credentials
			// use all facade methods to display its available operations

			// ====================================================================

		} catch (CouponSystemException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {

			try {
				// Stop the system =================
				// stop the daily job thread - use join before you proceed
				job.interrupt(); // use your custom method to really stop the job
				try {
					job.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// close the connection pool
				ConnectionPool.getInstance().cloaseAllConnections();
				// ==================================
			} catch (CouponSystemException e) {
				e.printStackTrace();
			}

		}

	}

}
