package d.abstracts.animals;

public class TestZoo {

	public static void main(String[] args) {

		Zoo zoo = new Zoo();

		zoo.add(new Fox());
		zoo.add(new Cat());
		zoo.add(new Ant());
		zoo.add(new Butterfly());
		zoo.add(new Bat());

		zoo.makeAllAnimalSpeak();

		System.out.println("=====================");
		Bat bat = new Bat();
		Ostrich ostrich = new Ostrich();
		zoo.makeFly(bat);
//		zoo.makeFly(ostrich);
		System.out.println("=====================");
		System.out.println(Flyer.MIN_ALT);
	}
}
