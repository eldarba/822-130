package a.exceptions.cares;

public class Test {

	public static void main(String[] args) {
		Car car = new Car();
		try {
			car.drive(30);
			car.drive(130);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("END");

	}

}
