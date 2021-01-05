package c.synchronizing;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("test starts in 3 seconds");
		Thread.sleep(3000);

		ListController lc = new ListController();
		GetLastElementThread t1 = new GetLastElementThread(lc);
		DeleteLastElementThread t2 = new DeleteLastElementThread(lc);

		t1.start();
		t2.start();

	}

}
