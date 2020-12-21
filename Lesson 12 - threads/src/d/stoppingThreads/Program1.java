package d.stoppingThreads;

public class Program1 {

	public static void main(String[] args) throws InterruptedException {

		{
//			MyStopableThread t1 = new MyStopableThread("t1");
//			t1.start();
//			Thread.sleep(500);
//			t1.interrupt();
		}

		{
			MyStopableThreadNoSleep t1 = new MyStopableThreadNoSleep("t1");
			t1.start();
			Thread.sleep(10);
			t1.interrupt();

		}
	}

}
