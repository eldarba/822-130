package a.cinema;

public class TestCinema {

	public static void main(String[] args) {

		Cinema c = new Cinema();

		c.add("Dan", 3, 2);
		c.add("Ran", 3, 4);

		System.out.println("===================");
		c.display();

		String removedName;

		removedName = c.remove(3, 2);
		System.out.println("removed value: " + removedName);

		removedName = c.remove(3, 2);
		System.out.println("removed value: " + removedName);
		System.out.println("===================");
		c.display();

		removedName = c.remove(3, 4);
		System.out.println("removed value: " + removedName);

		removedName = c.remove(3, 4);
		System.out.println("removed value: " + removedName);
		System.out.println("===================");
		c.display();

	}
}
