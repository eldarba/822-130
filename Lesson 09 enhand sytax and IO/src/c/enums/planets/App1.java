package c.enums.planets;

public class App1 {

	public static void main(String[] args) {

//		try {
//			Class.forName("c.enums.planets.Planet");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

		Planet p = Planet.MARS;

		System.out.println(p);
		System.out.println("mass: " + p.getMass());
		System.out.println("orbit: " + p.getOrbit());

	}

}
