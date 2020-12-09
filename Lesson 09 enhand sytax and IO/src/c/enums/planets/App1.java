package c.enums.planets;

public class App1 {

	public static void main(String[] args) {

		Planet p = Planet.MARS;

		System.out.println(p);
		System.out.println("mass: " + p.getMass());
		System.out.println("orbit: " + p.getOrbit());

	}

}
