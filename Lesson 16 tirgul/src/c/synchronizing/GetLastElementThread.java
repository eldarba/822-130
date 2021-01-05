package c.synchronizing;

public class GetLastElementThread extends Thread {

	private ListController lc;

	public GetLastElementThread(ListController lc) {
		super();
		this.lc = lc;
	}

	@Override
	public void run() {
		lc.printList();
		System.out.println(lc.getLastElement());
	}

}
