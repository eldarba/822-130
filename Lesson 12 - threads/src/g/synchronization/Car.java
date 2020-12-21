package g.synchronization;

public class Car {

	private int number;
	private int km;

	public Car(int number) {
		super();
		this.number = number;
	}

	public synchronized void drive(int distance) {
		Thread curr = Thread.currentThread();
		System.out.println(curr.getName() + " statrt driving at " + km + " km for a distance of " + distance
				+ " km with car: " + number);
		this.km += distance;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(curr.getName() + " finished driving at " + km + " with car: " + number);
	}

	public void turnRadioOn() {
		Thread curr = Thread.currentThread();
		System.out.println(curr.getName() + " turned radio on");
	}

}
