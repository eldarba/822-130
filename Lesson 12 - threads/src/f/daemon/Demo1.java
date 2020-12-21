package f.daemon;

import d.stoppingThreads.MyStopableThread;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {

		MyStopableThread t1 = new MyStopableThread("t1");
		MyStopableThread t2 = new MyStopableThread("t2");

		t2.setDaemon(true); // set t2 as daemon

		System.out.println("is t1 daemon: " + t1.isDaemon());
		System.out.println("is t2 daemon: " + t2.isDaemon());

		t1.start();
		t2.start();

		Thread.sleep(1500);
		t1.interrupt();

	}

}
