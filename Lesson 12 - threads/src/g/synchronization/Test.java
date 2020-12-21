package g.synchronization;

public class Test {

	public static void main(String[] args) {

		Car car = new Car(101);
		Car car2 = new Car(102);
		CarDriver ron = new CarDriver("Ron", car, 35);
		CarDriver danna = new CarDriver("Danna", car, 100);
		CarDriver dan = new CarDriver("Dan", car, 25);
		CarDriver lea = new CarDriver("Lea", car2, 20);
		ron.start();
		danna.start();
		dan.start();
		lea.start();

	}

}
