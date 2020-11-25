package d.abstracts.animals;

public class Test2 {

	public static void main(String[] args) {

		Animal animal = new Hawk();
		animal = new Bat();
		animal = new Ant();

		System.out.println(animal instanceof Hawk);
		System.out.println(animal instanceof Animal);
		System.out.println(animal instanceof Object);
		System.out.println(animal instanceof Navigator);
		System.out.println(animal instanceof Flyer);
		System.out.println(animal instanceof AdvancedFlyer);

	}

}
