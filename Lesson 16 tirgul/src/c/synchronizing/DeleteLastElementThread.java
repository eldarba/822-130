package c.synchronizing;

public class DeleteLastElementThread extends Thread {

	private ListController lc;

	public DeleteLastElementThread(ListController lc) {
		super();
		this.lc = lc;
	}

	@Override
	public void run() {
		lc.printList();
		lc.deleteLastElement();
	}

}
