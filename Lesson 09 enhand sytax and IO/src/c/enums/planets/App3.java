package c.enums.planets;

public class App3 {

	public static void main(String[] args) {

		Planet p = Planet.MARS;

		switch (p) {
		case EARTH:
			System.out.println("earth");
			break;
		case JUPITER:
			System.out.println("jupiter");
			break;
		case MARS:
			System.out.println("mars");
			break;

		default:
			break;
		}

	}

}
